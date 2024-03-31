package com.frankzhou.api.controller;

import com.frankzhou.api.service.AppApiService;
import com.frankzhou.api.service.AppInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 应用管理
 * @date 2024-03-10
 */
@RestController
@RequestMapping("/app")
public class AppController {

    @Resource
    private AppInfoService appInfoService;

    @Resource
    private AppApiService appApiService;
}
