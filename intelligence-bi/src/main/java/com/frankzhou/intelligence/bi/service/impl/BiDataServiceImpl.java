package com.frankzhou.intelligence.bi.service.impl;

import com.frankzhou.intelligence.bi.dao.BiDataDao;
import com.frankzhou.intelligence.bi.service.BiDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description bi图表自定义数据service层实现类
 * @date 2024-03-16
 */
@Slf4j
@Service
public class BiDataServiceImpl implements BiDataService {

    @Resource
    private BiDataDao biDataDao;

}




