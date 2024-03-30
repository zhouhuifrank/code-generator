package com.frankzhou.api.domain.dto.datasource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 数据源查询请求类
 * @date 2024-03-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiDatasourceQueryDTO {

    private Long datasourceId;
    private List<Long> datasourceIdIn;

    private String datasourceName;
    private String datasourceNameLike;

    private String dbType;
    private List<String> dbTypeIn;
}
