package com.frankzhou.api.domain.dto.column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description api数据表字段查询请求类
 * @date 2024-03-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiColumnQueryDTO {

    private Long tableId;
    private List<Long> tableIdIn;

    private Long columnId;

    private String columnNameEn;
    private String columnNameEnLike;

    private String columnNameCn;
    private String columnNameCnLike;

    private String dataType;

    /**
     * 字段中文名或者英文面搜索项
     */
    private String keyWord;

}
