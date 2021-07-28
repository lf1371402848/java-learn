package com.test.controller;

import com.test.bean.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 服务消费端
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/user/save1")
    @ResponseBody
    public Map<String, Object> save(User user) {
        // 调用本地服务代码，本地服务代码远程调用application service服务提供方。
        Map<String, Object> result = this.userService.save(user);
        System.out.println("远程调用返回的结果：" + result);
        return result;
    }


    @GetMapping("/user/save2")
    @ResponseBody
    public Map<String, Object> save2(User user) {
        System.out.println("UserController.save2:" + user);
        Map<String, Object> map = restTemplate.postForObject("http://ribbon-service/user/save", user, Map.class);
        return map;
    }
}
