package com.frankzhou.api.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frankzhou.api.domain.entity.ApiDatasource;
import com.frankzhou.api.mapper.ApiDatasourceMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 针对api_datasource表的数据库操作DAO
 * @date 2024-03-26
 */
@Component
public class ApiDatasourceDao extends ServiceImpl<ApiDatasourceMapper, ApiDatasource> {

    @Resource
    private ApiDatasourceMapper datasourceMapper;


}
