package com.frankzhou.intelligence.bi.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frankzhou.intelligence.bi.domain.entity.BiData;
import com.frankzhou.intelligence.bi.mapper.BiDataMapper;
import org.springframework.stereotype.Component;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description bi自定义数据dao层
 * @date 2024-03-11
 */
@Component
public class BiDataDao extends ServiceImpl<BiDataMapper, BiData> {
}
