package com.frankzhou.api.controller;

import com.frankzhou.api.service.AppLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 应用调用日志管理
 * @date 2024-03-10
 */
@RestController
@RequestMapping("/log")
public class AppLogController {

    @Resource
    private AppLogService appLogService;
}
