package com.frankzhou.intelligence.bi.domain.dto.chart;

import com.frankzhou.common.base.PageRequest;
import lombok.Data;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description bi图表查询请求类
 * @date 2024-03-16
 */
@Data
public class BiChartQueryDTO extends PageRequest {

    private String chartNo;

    private String chartName;
    private String chartNameLike;

    private String tableNo;
    private List<String> tableNoIn;

    private String chartType;
    private List<String> chartTypeIn;

    private Integer chartStatus;
    private List<Integer> chartStatusIn;

    private String createUser;
}
