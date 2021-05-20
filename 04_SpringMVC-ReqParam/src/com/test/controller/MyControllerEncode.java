package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class MyControllerEncode {

    //声明单元方法：处理请求
    @RequestMapping("argCode")
    public String demoArgCode(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        System.out.println(response.getCharacterEncoding());
        System.out.println(request.getCharacterEncoding());
        System.out.println(request.getParameter("uname"));
        return "index.jsp";
    }


}
