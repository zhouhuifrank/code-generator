package com.frankzhou.intelligence.bi.domain.dto.invoke;

import com.frankzhou.common.base.BaseDTO;
import com.frankzhou.intelligence.bi.domain.dto.invoke.ReliableInvokeDTO;
import lombok.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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
@EqualsAndHashCode(callSuper = false)
public class ReliableMessageRecordDTO extends BaseDTO {

    private String messageType;

    private ReliableInvokeDTO reliableInvokeDTO;

    private Integer messageStatus;

    private Date nextRetryTime;

    private Integer retryCount;

    private Integer maxRetryCount;

    private String executor;

    private String failReason;

}
