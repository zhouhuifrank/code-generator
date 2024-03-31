package com.frankzhou.intelligence.bi.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frankzhou.common.enums.DataStatusEnum;
import com.frankzhou.common.util.DateUtil;
import com.frankzhou.common.util.JsonUtil;
import com.frankzhou.intelligence.bi.domain.dto.invoke.ReliableInvokeDTO;
import com.frankzhou.intelligence.bi.domain.dto.invoke.ReliableMessageRecordDTO;
import com.frankzhou.intelligence.bi.domain.entity.ReliableMessageRecord;
import com.frankzhou.intelligence.bi.domain.enums.MessageStatusEnum;
import com.frankzhou.intelligence.bi.mapper.ReliableMessageRecordMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 可靠消息调用dao层
 * @date 2024-03-16
 */
@Component
public class ReliableInvokeDao extends ServiceImpl<ReliableMessageRecordMapper, ReliableMessageRecord> {

    @Resource
    private ReliableMessageRecordMapper messageRecordMapper;

    public boolean saveRecord(ReliableMessageRecordDTO recordDTO) {
        ReliableMessageRecord messageRecord = new ReliableMessageRecord();
        BeanUtils.copyProperties(recordDTO, messageRecord);
        ReliableInvokeDTO reliableInvokeDTO = recordDTO.getReliableInvokeDTO();
        String messageJson = JsonUtil.toJsonStr(reliableInvokeDTO);
        messageRecord.setMessageJson(messageJson);
        messageRecord.setStatus(DataStatusEnum.NORMAL.getCode());
        boolean success = this.save(messageRecord);
        // 将返回回来的自增id赋值给messageRecordDTO
        recordDTO.setId(messageRecord.getId());
        return success;
    }

    public boolean updateRecord(ReliableMessageRecordDTO recordDTO) {
        ReliableMessageRecord messageRecord = new ReliableMessageRecord();
        BeanUtils.copyProperties(recordDTO, messageRecord);
        ReliableInvokeDTO reliableInvokeDTO = recordDTO.getReliableInvokeDTO();
        String messageJson = JsonUtil.toJsonStr(reliableInvokeDTO);
        messageRecord.setMessageJson(messageJson);
        return this.updateById(messageRecord);
    }

    public boolean removeRecord(Long id) {
        return this.removeById(id);
    }

    public boolean batchDelete(List<Long> idList) {
        return removeBatchByIds(idList);
    }

    /**
     * 查询处于待发送和异常状态的消息，并且已经到达下次重试时间
     */
    public List<ReliableMessageRecordDTO> queryWaitingMessage() {
        // 下次重试时间<=当前时间 创建时间<=两分钟前 避免刚插入的消息立即被取出
        Date nowTime = new Date();
        Date afterTime = DateUtil.addMinutes(nowTime, -2);
        List<Integer> messageStatusList = Arrays.asList(MessageStatusEnum.SEND_BEFORE.getCode(), MessageStatusEnum.EXCEPTION.getCode());
        List<ReliableMessageRecord> recordList = lambdaQuery()
                .le(ReliableMessageRecord::getNextRetryTime, nowTime)
                .le(ReliableMessageRecord::getCreateTime, afterTime)
                .in(ReliableMessageRecord::getMessageStatus, messageStatusList)
                .eq(ReliableMessageRecord::getStatus, DataStatusEnum.NORMAL.getCode())
                .list();

        List<ReliableMessageRecordDTO> waitingMessageList = new ArrayList<>();
        recordList.forEach(record -> {
            ReliableMessageRecordDTO recordDTO = new ReliableMessageRecordDTO();
            BeanUtils.copyProperties(record, recordDTO);
            String messageJson = record.getMessageJson();
            ReliableInvokeDTO reliableInvokeDTO = JsonUtil.toObject(messageJson, ReliableInvokeDTO.class);
            recordDTO.setReliableInvokeDTO(reliableInvokeDTO);
            waitingMessageList.add(recordDTO);
        });
        return waitingMessageList;
    }

    /**
     * 查询已经被标记为删除 7天前被删除的
     */
    public List<ReliableMessageRecord> queryDeletedRecord() {
        Date beforeDate = DateUtil.addDays(new Date(), -7);
        List<ReliableMessageRecord> recordList = lambdaQuery()
                .eq(ReliableMessageRecord::getMessageStatus, MessageStatusEnum.SUCCESS.getCode())
                .eq(ReliableMessageRecord::getStatus, DataStatusEnum.DELETED.getCode())
                .le(ReliableMessageRecord::getCreateTime, beforeDate)
                .list();
        return recordList;
    }
}
