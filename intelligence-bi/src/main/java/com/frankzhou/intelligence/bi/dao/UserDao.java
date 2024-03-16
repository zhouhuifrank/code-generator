package com.frankzhou.intelligence.bi.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frankzhou.intelligence.bi.domain.entity.User;
import com.frankzhou.intelligence.bi.mapper.UserMapper;
import org.springframework.stereotype.Component;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 用户管理dao层
 * @date 2024-03-11
 */
@Component
public class UserDao extends ServiceImpl<UserMapper, User> {
}
