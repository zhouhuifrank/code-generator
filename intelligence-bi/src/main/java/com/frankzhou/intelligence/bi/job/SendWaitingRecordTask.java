package com.frankzhou.intelligence.bi.job;

import com.frankzhou.common.base.ApiResultDTO;
import com.frankzhou.intelligence.bi.dao.ReliableInvokeDao;
import com.frankzhou.intelligence.bi.domain.dto.invoke.ReliableMessageRecordDTO;
import com.frankzhou.intelligence.bi.domain.entity.ReliableMessageRecord;
import com.frankzhou.intelligence.bi.service.ReliableInvokeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 可靠消息调用定时任务
 * @date 2024-03-17
 */
@Slf4j
@Component
@EnableScheduling
public class SendWaitingRecordTask {

    @Resource
    private ReliableInvokeService reliableInvokeService;

    @Resource
    private ReliableInvokeDao reliableInvokeDao;

    /**
     * 每两分钟查询一次本地消息表，然后调用执行方法
     */
    @Scheduled(cron = "* */2 * ? * *")
    public void sendRecord() {
        List<ReliableMessageRecordDTO> recordList = reliableInvokeDao.queryWaitingMessage();
        for (ReliableMessageRecordDTO recordDTO : recordList) {
            reliableInvokeService.doAsyncInvoke(recordDTO);
        }
    }

    /**
     * 每天6点 删除7天前执行成功且被标记为删除状态的消息记录
     */
    @Scheduled(cron = "0 0 6 ? * *")
    public void clearDeletedRecord() {
        List<ReliableMessageRecord> deleteRecordList = reliableInvokeDao.queryDeletedRecord();
        List<Long> idList = deleteRecordList.stream().map(ReliableMessageRecord::getId).collect(Collectors.toList());
        reliableInvokeDao.batchDelete(idList);
    }
}
