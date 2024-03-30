package com.frankzhou.api.domain.dto.column;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description api数据表字段请求类
 * @date 2024-03-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiColumnDTO {

    private Long tableId;

    private Long columnId;

    private String columnNameEn;

    private String columnNameCn;

    private String columnDesc;

    private String dataType;

    private Integer dataLength;

    private Integer dataPrecision;

    private Integer keyFlag;

    private Integer indexFlag;
}
