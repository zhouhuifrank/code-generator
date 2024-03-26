package com.frankzhou.intelligence.bi.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.frankzhou.common.base.ApiResultCodeConstant;
import com.frankzhou.common.base.ApiResultDTO;
import com.frankzhou.common.base.DeleteRequest;
import com.frankzhou.common.enums.DataStatusEnum;
import com.frankzhou.common.exception.BusinessException;
import com.frankzhou.common.util.DateUtil;
import com.frankzhou.common.util.JsonUtil;
import com.frankzhou.intelligence.bi.common.constants.IntelligenceBiConstant;
import com.frankzhou.intelligence.bi.dao.ReliableInvokeDao;
import com.frankzhou.intelligence.bi.domain.dto.invoke.ReliableInvokeDTO;
import com.frankzhou.intelligence.bi.domain.dto.invoke.ReliableMessageRecordDTO;
import com.frankzhou.intelligence.bi.domain.enums.MessageStatusEnum;
import com.frankzhou.intelligence.bi.service.ReliableInvokeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 可靠消息调用service层
 * @date 2024-03-16
 */
@Slf4j
@Service
public class ReliableInvokeServiceImpl implements ReliableInvokeService {

    @Resource
    private ReliableInvokeDao reliableInvokeDao;

    @Override
    public ApiResultDTO<Boolean> saveRecord(ReliableMessageRecordDTO messageRecordDTO) {
        boolean success = reliableInvokeDao.saveRecord(messageRecordDTO);
        if (!success) {
            throw new BusinessException(ApiResultCodeConstant.DB_INSERT_COUNT_ERROR);
        }

        return ApiResultDTO.getSuccessResult(Boolean.TRUE);
    }

    @Override
    public ApiResultDTO<Boolean> updateRecord(ReliableMessageRecordDTO messageRecordDTO) {
        boolean success = reliableInvokeDao.updateRecord(messageRecordDTO);
        if (!success) {
            throw new BusinessException(ApiResultCodeConstant.DB_UPDATE_COUNT_ERROR);
        }

        return ApiResultDTO.getSuccessResult(Boolean.TRUE);
    }

    @Override
    public ApiResultDTO<Boolean> removeRecord(DeleteRequest deleteRequest) {
        if (Objects.isNull(deleteRequest.getId())) {
            throw new BusinessException(ApiResultCodeConstant.DELETE_ID_NULL);
        }

        boolean success = reliableInvokeDao.removeRecord(deleteRequest.getId());
        if (!success) {
            throw new BusinessException(ApiResultCodeConstant.DB_DELETE_COUNT_ERROR);
        }

        return ApiResultDTO.getSuccessResult(Boolean.TRUE);
    }

    @Override
    public ApiResultDTO<List<ReliableMessageRecordDTO>> queryWaitingRecordList() {
        List<ReliableMessageRecordDTO> recordDTOList = reliableInvokeDao.queryWaitingMessage();
        // 判空
        return ApiResultDTO.getSuccessResult(recordDTOList);
    }

    @Override
    public ApiResultDTO<Boolean> doInvoke(ReliableMessageRecordDTO messageRecordDTO, boolean async) {
        boolean isInTransaction = TransactionSynchronizationManager.isActualTransactionActive();
        if (!isInTransaction) {
            return ApiResultDTO.getSuccessResult(Boolean.TRUE);
        }

        // 保存本地消息记录 在同一个事务内
        this.saveRecord(messageRecordDTO);

        // 注册一个hook 在事务提交之后执行
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                /// 将消息状态设置为发送中
                messageRecordDTO.setMessageStatus(MessageStatusEnum.SENDING.getCode());
                reliableInvokeDao.updateRecord(messageRecordDTO);

                if (async) {
                    doAsyncInvoke(messageRecordDTO);
                    return;
                }

                doSyncInvoke(messageRecordDTO);
            }
        });

        return ApiResultDTO.getSuccessResult(Boolean.TRUE);
    }

    @Override
    public void doAsyncInvoke(ReliableMessageRecordDTO recordDTO) {
        String executor = recordDTO.getExecutor();
        // 获取对应的线程池的bean

    }

    @Override
    public void doSyncInvoke(ReliableMessageRecordDTO recordDTO) {
        ReliableInvokeDTO reliableInvokeDTO = recordDTO.getReliableInvokeDTO();

        try {
            // 获取到对应的类中的执行方法
            String className = reliableInvokeDTO.getClassName();
            String methodName = reliableInvokeDTO.getMethodName();
            String parameterTypes = reliableInvokeDTO.getParameterTypes();
            String args = reliableInvokeDTO.getArgs();

            Class<?> beanClass = Class.forName(className);
            Class<?>[] parameterClassArray = getParameterClass(parameterTypes);
            // 因为方法有重载的情况 所以需要根据类名+方法名+参数类型来获取对应的方法
            Method method = beanClass.getMethod(methodName, parameterClassArray);

            // 解析方法入参值
            Object[] argsArray = getArgValues(args, parameterClassArray);
            // 进行调用
            method.invoke(beanClass, argsArray);
            // 更新消息记录 消息状态设置为成功 数据状态设置为删除
            recordDTO.setMessageStatus(MessageStatusEnum.SUCCESS.getCode());
            recordDTO.setStatus(DataStatusEnum.DELETED.getCode());
            reliableInvokeDao.updateRecord(recordDTO);
        } catch (Exception e) {
            log.warn("doSyncInvoke errorMsg:{}", e.getMessage());
            // 进行重试
            recordDTO.setFailReason(e.getMessage());
            tryNextRecord(recordDTO);
        }
    }

    private Class<?>[] getParameterClass( String parameterTypes) {
        List<String> parameterStringList = JsonUtil.toList(parameterTypes, String.class);
        Class<?>[] parameterClassArray = new Class[parameterStringList.size()];
        for (int i=0; i<parameterStringList.size(); i++) {
            try {
                Class<?> parameterClass = Class.forName(parameterStringList.get(i));
                parameterClassArray[i] = parameterClass;
            } catch (ClassNotFoundException e) {
                log.warn("getParameterClass errorMsg:{}", e.getMessage());
            }
        }

        return parameterClassArray;
    }

    private Object[] getArgValues(String args, Class<?>[] parameterClassArray) {
        JsonNode jsonNode = JsonUtil.toJsonNode(args);
        Object[] argsArray = new Object[jsonNode.size()];
        for (int i=0; i<jsonNode.size(); i++) {
            JsonNode treeNode = jsonNode.get(i);
            Object object = JsonUtil.nodeToValue(jsonNode, parameterClassArray[i]);
            argsArray[i] = object;
        }
        return argsArray;
    }

    /**
     * 保存相关参数，进行下一次重试
     */
    private void tryNextRecord(ReliableMessageRecordDTO recordDTO) {
        Integer retryCount = recordDTO.getRetryCount();
        if (retryCount >= recordDTO.getMaxRetryCount()) {
            // 达到最大重试次数 标记为失败状态 不会再被定时任务扫描到
            recordDTO.setMessageStatus(MessageStatusEnum.FAIL.getCode());
        } else {
            // 标记为异常状态 可被定时任务扫描到执行
            recordDTO.setMessageStatus(MessageStatusEnum.EXCEPTION.getCode());
            recordDTO.setNextRetryTime(getNextRetryTime(retryCount));
            recordDTO.setRetryCount(retryCount + 1);
        }

        reliableInvokeDao.updateRecord(recordDTO);
    }

    /**
     * 计算下一次重试的时间
     */
    private Date getNextRetryTime(Integer retryCount) {
        int minutes = (int) Math.pow(IntelligenceBiConstant.RECORD_RETRY_INTERVAL, retryCount+1);
        Date nextRetryTime = DateUtil.addMinutes(new Date(), minutes);
        return nextRetryTime;
    }
}




