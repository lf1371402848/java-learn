package com.test.controller;

import com.test.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 提供服务的控制器
 */
@Controller
public class UserController {
    @RequestMapping(value = "/user/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody User user){
        System.out.println("UserController.save:ribbon-service2");
        System.out.println("新增用户数据： " + user);
        Map<String, Object> result = new HashMap<>();
        result.put("code", "200"); // 返回的状态码
        result.put("message", "新增用户成功"); // 返回的处理结果消息。
        return result;
    }
}
