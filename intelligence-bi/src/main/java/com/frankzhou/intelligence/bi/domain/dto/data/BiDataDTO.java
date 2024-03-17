package com.frankzhou.intelligence.bi.domain.dto.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description bi图表自定义数据请求类
 * @date 2024-03-16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BiDataDTO {

    private String tableNo;

    private String tableNameEn;

    private String tableNameCn;

    private String dataFileNo;

    private Integer importStatus;

    private String createUser;

    private String updateUser;
}
