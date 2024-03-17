package com.frankzhou.common.exception;

import com.frankzhou.common.base.ApiResultCodeDTO;
import com.frankzhou.common.base.ApiResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 全局异常处理
 * @date 2023-04-21
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ApiResultDTO<?> businessExceptionHandler(BusinessException e) {
        log.warn("business exception: {}",e.getMessage());
        return ApiResultDTO.getResult(new ApiResultCodeDTO(e.getCode(),e.getInfo(),e.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ApiResultDTO<?> runtimeExceptionHandler(RuntimeException e) {
        log.warn("runtime exception:{}",e.getMessage());
        return ApiResultDTO.getResult(new ApiResultCodeDTO(9999,"system exception",e.getMessage()));
    }
}
