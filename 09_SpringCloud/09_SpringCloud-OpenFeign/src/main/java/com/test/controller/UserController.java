package com.test.controller;


import com.test.bean.User;
import com.test.feign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 服务消费端
 */
@Controller
public class UserController {
    @Autowired
    private UserServiceFeign userService;

    @RequestMapping(value="/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody User user) {
        return userService.save(user);
    }
}
