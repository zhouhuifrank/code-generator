package com.frankzhou.api.controller;

import com.frankzhou.api.service.ApiColumnService;
import com.frankzhou.api.service.ApiTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 数据表管理
 * @date 2024-03-10
 */
@RestController
@RequestMapping("/table")
public class ApiTableController {

    @Resource
    private ApiTableService tableService;

    @Resource
    private ApiColumnService columnService;
}
