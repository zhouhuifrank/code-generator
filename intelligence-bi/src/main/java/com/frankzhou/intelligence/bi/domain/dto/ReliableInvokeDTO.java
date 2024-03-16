package com.frankzhou.intelligence.bi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 可靠调用消息体
 * @date 2024-03-16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReliableInvokeDTO {

    private String className;

    private String methodName;

    private String parameterTypes;

    private String args;
}
