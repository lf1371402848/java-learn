package com.test.service;

import com.test.bean.User;

import java.io.IOException;

public interface UserService {
    //用户登录
    User userLoginService(String uname, String pwd) throws IOException;
}
