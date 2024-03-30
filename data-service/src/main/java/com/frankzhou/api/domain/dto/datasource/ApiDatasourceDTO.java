package com.frankzhou.api.domain.dto.datasource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 数据源请求类
 * @date 2024-03-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiDatasourceDTO {

    private Long datasourceId;

    private String datasourceName;

    private String dbType;

    private String connectIp;

    private String connectUrl;

    private String connectUser;

    private String connectPassword;

    private String dbDesc;

}
