package com.frankzhou.api.domain.dto.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description api数据表查询请求类
 * @date 2024-03-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiTableQueryDTO {

    private Long datasourceId;
    private List<Long> datasourceIdIn;

    private Long tableId;
    private List<Long> tableIdIn;

    private String tableNameEn;
    private String tableNameEnLike;

    private String tableNameCn;
    private String tableNameCnLike;

    private Integer renewalFrequency;

    // 数据表中文名或者英文名搜索项
    private String keyWord;

}
