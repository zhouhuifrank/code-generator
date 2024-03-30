package com.frankzhou.api.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frankzhou.api.domain.entity.ApiTable;
import com.frankzhou.api.mapper.ApiTableMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 针对api_table表的的数据库操作DAO
 * @date 2024-03-26
 */
@Component
public class ApiTableDao extends ServiceImpl<ApiTableMapper, ApiTable> {

    @Resource
    private ApiTableMapper tableMapper;

}
