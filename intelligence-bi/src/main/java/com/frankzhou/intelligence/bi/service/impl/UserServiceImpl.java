package com.frankzhou.intelligence.bi.service.impl;

import com.frankzhou.intelligence.bi.dao.UserDao;
import com.frankzhou.intelligence.bi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 用户登录注册及用户管理service层实现类
 * @date 2024-03-16
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
}




