package com.frankzhou.api.domain.dto.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description api数据表请求类
 * @date 2024-03-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiTableDTO {

    private Long datasourceId;

    private Long tableId;

    private String tableNameEn;

    private String tableNameCn;

    private String tableDesc;

    private Integer renewalFrequency;

}
