package com.frankzhou.common.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: this.FrankZhou
 * @date: 2012/12/27
 * @description: 分页查询结果通用返回类
 */
@Data
@NoArgsConstructor
public class ApiPageResultDTO<T extends List<?>> extends ApiResultDTO<T> {
    private static final Long serialVersionUID = 1L;
    private T pageResult;
    private Integer pageCount;

    public ApiPageResultDTO(Integer pageCount, T pageResult, Integer resultCode, String error, String errorMsg) {
        super(null,resultCode,error,errorMsg,true,null);
        this.pageCount = pageCount;
        this.pageResult = pageResult;
    }

    public static <T> ApiPageResultDTO<List<T>> getErrorPageResult(ApiResultDTO apiResultDTO) {
        Integer resultCode = apiResultDTO.getResultCode();
        String error = apiResultDTO.getError();
        String errorMsg = apiResultDTO.getErrorMsg();
        return new ApiPageResultDTO<>(0,(List)null,resultCode,error,errorMsg);
    }

    public static <T> ApiPageResultDTO<List<T>> getSuccessPageResult() {
        return getResult(0,new ArrayList<>(0),ApiResultCodeConstant.SUCCESS);
    }

    public static <T> ApiPageResultDTO<List<T>> getSuccessPageResult(Integer pageCount, List<T> pageResult) {
        return getResult(pageCount,pageResult,ApiResultCodeConstant.SUCCESS);
    }

    public static <T> ApiPageResultDTO<List<T>> getResult(Integer pageCount,List<T> pageResult,ApiResultCodeDTO apiResultCodeDTO) {
        return new ApiPageResultDTO(pageCount,pageResult,apiResultCodeDTO.getCode(),apiResultCodeDTO.getMessage(),apiResultCodeDTO.getMessageInfo());
    }

}
