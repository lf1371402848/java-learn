package com.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//@RestController整合了@Controller与@ResponseBody
public class TestController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}
