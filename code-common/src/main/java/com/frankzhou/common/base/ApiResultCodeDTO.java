package com.frankzhou.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 统一错误码
 * @date 2024-03-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResultCodeDTO implements Serializable {
    private static final Long serialVersionUID = 1L;

    /**
     * 错误状态码
     */
    private Integer code;

    /**
     * 错误英文信息
     */
    private String message;

    /**
     * 错误中文信息
     */
    private String messageInfo;
}