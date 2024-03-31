package com.frankzhou.api.controller;

import com.frankzhou.api.service.ApiDatasourceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 数据源管理
 * @date 2024-03-10
 */
@RestController
@RequestMapping("/datasource")
public class ApiDatasourceController {

    @Resource
    private ApiDatasourceService datasourceService;
}
