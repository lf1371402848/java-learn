package com.test.service.impl;

import com.test.mapper.UserMapper;
import com.test.bean.User;
import com.test.service.UserService;

import java.io.IOException;

public class UserServiceImpl implements UserService {
    //声明mapper层属性
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //用户登录
    @Override
    public User userLoginService(String uname, String pwd) throws IOException {
        //2.完成数据库查询
        User user = userMapper.userLoginMapper(uname, pwd);
        //3.返回
        return user;
    }
}
