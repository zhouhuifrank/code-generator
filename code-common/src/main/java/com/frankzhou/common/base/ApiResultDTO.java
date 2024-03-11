package com.frankzhou.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 统一前端返回类
 * @date 2023-12-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResultDTO<T> implements Serializable {
    private static final Long serialVersionUID = 1L;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 响应状态码 200表示ok 其他表示异常
     */
    private Integer resultCode;

    /**
     * 错误英文描述
     */
    private String error;

    /**
     * 错误中文描述
     */
    private String errorMsg;

    /**
     *  是否请求成功
     */
    private Boolean isSuccess;

    /**
     * 缓存数据
     */
    private Map<String,Object> cacheMap = new HashMap<>();


    public static <T> ApiResultDTO<T> getResult(ApiResultCodeDTO apiResultCodeDTO) {
        ApiResultDTO<T> result = new ApiResultDTO<>();
        result.setResultCode(apiResultCodeDTO.getCode());
        result.setError(apiResultCodeDTO.getMessage());
        result.setErrorMsg(apiResultCodeDTO.getMessageInfo());
        result.setIsSuccess(false);

        return result;
    }

    public static <T> ApiResultDTO<T> getSuccessResult() {
        ApiResultDTO<T> result = new ApiResultDTO<>();
        result.setResultCode(200);
        result.setIsSuccess(true);

        return result;
    }

    public static <T> ApiResultDTO<T> getSuccessResult(T data) {
        ApiResultDTO<T> result = new ApiResultDTO<>();
        result.setResultCode(200);
        result.setData(data);
        result.setIsSuccess(true);

        return result;
    }

    public static <T> ApiResultDTO<T> getErrorResult(ApiResultCodeDTO apiResultCodeDTO) {
        ApiResultDTO<T> result = new ApiResultDTO<>();
        result.setResultCode(apiResultCodeDTO.getCode());
        result.setError(apiResultCodeDTO.getMessage());
        result.setErrorMsg(apiResultCodeDTO.getMessageInfo());
        result.setIsSuccess(false);

        return result;
    }

    public ApiResultDTO<T> addMap(String key, Object value) {
        this.cacheMap.put(key,value);
        return this;
    }

    private Boolean requestSuccessIs() {
        return this.isSuccess == true;
    }
}
