package com.frankzhou.api.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frankzhou.api.domain.entity.ApiColumn;
import com.frankzhou.api.mapper.ApiColumnMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 针对api_column的数据库操作DAO
 * @date 2024-03-26
 */
@Component
public class ApiColumnDao extends ServiceImpl<ApiColumnMapper, ApiColumn> {

    @Resource
    private ApiColumnMapper columnMapper;
}
