package com.frankzhou.intelligence.bi.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frankzhou.intelligence.bi.domain.entity.BiChart;
import com.frankzhou.intelligence.bi.mapper.BiChartMapper;
import org.springframework.stereotype.Component;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description bi图表管理dao层
 * @date 2024-03-10
 */
@Component
public class BiChartDao extends ServiceImpl<BiChartMapper, BiChart> {
}
