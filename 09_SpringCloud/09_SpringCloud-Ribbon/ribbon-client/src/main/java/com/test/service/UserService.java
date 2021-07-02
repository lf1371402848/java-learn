package com.test.service;

import com.test.bean.User;

import java.util.Map;

public interface UserService {
    Map<String, Object> save(User user);
}
