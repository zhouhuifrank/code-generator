package com.frankzhou.intelligence.bi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frankzhou.intelligence.bi.domain.entity.User;
import com.frankzhou.intelligence.bi.service.UserService;
import com.frankzhou.intelligence.bi.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 22806
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-03-11 21:55:19
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




