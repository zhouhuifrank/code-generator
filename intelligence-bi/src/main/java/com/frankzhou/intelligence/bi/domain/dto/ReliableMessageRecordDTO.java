package com.frankzhou.intelligence.bi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 可靠调用消息记录
 * @date 2024-03-16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReliableMessageRecordDTO {

    private String messageType;

    private ReliableInvokeDTO reliableInvokeDTO;

    private Integer messageStatus;

    private Date nextRetryTime;

    private Integer retryCount;

    private Integer maxRetryCount;

    private String failReason;
}
