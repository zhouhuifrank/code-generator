package com.frankzhou.intelligence.bi.domain.dto.data;

import lombok.Data;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description bi图表自定义数据查询类
 * @date 2024-03-16
 */
@Data
public class BiDataQueryDTO {

    private String tableNo;

    private String tableNameEn;
    private String tableNameEnLike;

    private String tableNameCn;
    private String tableNameCnLike;

    private String dataFileNo;

    private Integer importStatus;
    private List<Integer> importStatusIn;

    private String createUser;
}
