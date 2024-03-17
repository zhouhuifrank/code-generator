package com.frankzhou.intelligence.bi.domain.dto.chart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description bi图表请求类
 * @date 2024-03-16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BiChartDTO {

    private String chartNo;

    private String chartName;

    private String analysisGoal;

    private String tableNo;

    private String chartType;

    private String analysisResult;

    private String resultData;

    private Integer chartStatus;

    private String createUser;

    private String updateUser;
}
