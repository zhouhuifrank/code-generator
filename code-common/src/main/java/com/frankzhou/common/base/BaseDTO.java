package com.frankzhou.common.base;

import lombok.Data;

import java.util.Date;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 基础DTO属性
 * @date 2024-03-17
 */
@Data
public abstract class BaseDTO {

    protected Long id;

    protected Date createTime;

    protected Date updateTIme;

    protected String status;
}
