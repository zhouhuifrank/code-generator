package com.frankzhou.api.controller;

import com.frankzhou.api.service.ApiGroupService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description api分组管理
 * @date 2024-03-09
 */
@RestController
@RequestMapping("/api/group")
public class ApiGroupController {

    @Resource
    private ApiGroupService apiGroupService;
}
