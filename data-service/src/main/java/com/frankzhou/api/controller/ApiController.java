package com.frankzhou.api.controller;

import com.frankzhou.api.service.ApiExecuteSqlService;
import com.frankzhou.api.service.ApiInfoService;
import com.frankzhou.api.service.ApiParamConfigService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description api服务
 * @date 2024-03-10
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    private ApiInfoService apiInfoService;

    @Resource
    private ApiExecuteSqlService ExecuteSqlService;

    @Resource
    private ApiParamConfigService paramConfigService;
}
