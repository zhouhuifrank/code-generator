package com.frankzhou.intelligence.bi.domain.dto.chart;

import com.frankzhou.common.base.BaseDTO;
import lombok.*;

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
@EqualsAndHashCode(callSuper = false)
public class BiChartDTO extends BaseDTO {

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
