package com.frankzhou.intelligence.bi.service.impl;

import com.frankzhou.intelligence.bi.dao.BiChartDao;
import com.frankzhou.intelligence.bi.service.BiChartService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description bi图表管理和智能分析service层实现类
 * @date 2024-03-16
 */
@Slf4j
@Service
public class BiChartServiceImpl implements BiChartService {

    @Resource
    private BiChartDao biChartDao;
}




