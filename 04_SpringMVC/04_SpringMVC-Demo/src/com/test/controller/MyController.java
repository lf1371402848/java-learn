package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器类
 */
@Controller
public class MyController {

    //声明请求处理的逻辑方法(单元方法)
    @RequestMapping("demo")
    public String demo(){
        System.out.println("我是处理请求的逻辑单元方法，由DispatcherServlet根据请求调用");
        return "aa";
    }


}
