package com.frankzhou.intelligence.bi.service;

import com.frankzhou.common.base.ApiResultDTO;
import com.frankzhou.common.base.DeleteRequest;
import com.frankzhou.intelligence.bi.domain.dto.invoke.ReliableMessageRecordDTO;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 可靠消息调用Service层
 * @date 2024-03-16
 */
public interface ReliableInvokeService {

    ApiResultDTO<Boolean> saveRecord(ReliableMessageRecordDTO messageRecordDTO);

    ApiResultDTO<Boolean> updateRecord(ReliableMessageRecordDTO messageRecordDTO);

    ApiResultDTO<Boolean> removeRecord(DeleteRequest deleteRequest);

    ApiResultDTO<List<ReliableMessageRecordDTO>> queryWaitingRecordList();

    ApiResultDTO<Boolean> doInvoke(ReliableMessageRecordDTO messageRecordDTO, boolean async);

    void doAsyncInvoke(ReliableMessageRecordDTO messageRecordDTO);

    void doSyncInvoke(ReliableMessageRecordDTO messageRecordDTO);
}
