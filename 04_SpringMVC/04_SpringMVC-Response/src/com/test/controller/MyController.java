package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制器类
 */
@Controller
public class MyController {

    //servlet方式响应
    //直接使用HttpServletResponse对象直接响应，不需要通过DispatcherServlet了,因此不需要返回值
    @RequestMapping(value = "/response_by_servlet")
    public void response_by_servlet(String name, int age, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //处理请求
        System.out.println("MyController.response_by_servlet:使用原生的response对象完成响应:" + name + ":" + age);
        //响应结果
            response.setContentType("text/html;charset=utf-8");
            //1、直接响应
//            response.getWriter().write("使用原生的response对象直接响应");
            //2、服务器内部跳转
            System.out.println(request.getContextPath());
            System.out.println(request.getRequestURL());
            request.getRequestDispatcher("/forward.jsp").forward(request, response);
//          request.getRequestDispatcher("/response_by_servlet1").forward(request, response);
            //3、客户端重定向
                //3.1 不带/
//                response.sendRedirect("redirect.jsp");
                //3.2 带/ request.getContextPath():获取当前的系统路径/springmvc-response
//                response.sendRedirect(request.getContextPath()+"/redirect.jsp");
//                response.sendRedirect("/springmvc-response/redirect.jsp");
    }

    //forward方式响应
    //通过DispatcherServlet请求转发资源,需要返回值
    @RequestMapping("/response_by_forward")
    public String response_by_forward(String name, int age) {
        //处理请求
        System.out.println("MyController.response_by_forward:使用原生的DispatcherServlet对象forward方式完成响应:" + name + ":" + age);
        //响应结果
        return "forward:content/forward.jsp";
    }

    @RequestMapping("/response_by_forward1")
    public String response_by_forward1(String name, int age) {
        //处理请求
        System.out.println("MyController.response_by_forward1:使用原生的DispatcherServlet对象forward方式完成响应:" + name + ":" + age);
        //响应结果
        return "content/forward.jsp";
    }

    //redirect方式响应
    //通过DispatcherServlet请求转发资源,需要返回值
    @RequestMapping("/response_by_redirect")
    public String response_by_redirect(String name, int age) {
        //处理请求
        System.out.println("MyController.response_by_redirect:使用原生的DispatcherServlet对象redirect方式完成响应:" + name + ":" + age);
        //响应结果
        return "redirect:/content/redirect.jsp";
    }

    @RequestMapping("/response_by_redirect1")
    public String response_by_redirect1(String name, int age) {
        //处理请求
        System.out.println("MyController.response_by_redirect1:使用原生的DispatcherServlet对象redirect方式完成响应:" + name + ":" + age);
        //响应结果
        return "redirect:content/redirect.jsp";
    }
}
