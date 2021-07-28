package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 控制器类
 */
@Controller
public class MyController {

    //InternalResourceView:服务器内部跳转
    @RequestMapping("demoForwardView")
    public View demoView(){
        System.out.println("MyController.demoView,InternalResourceView完成服务器内部跳转，由DispatcherServlet根据请求调用");
        return new InternalResourceView("forward.jsp");
    }

    //RedirectView:客户端重定向
    @RequestMapping("demoRedirectView")
    public View demoRedirectView(){
        System.out.println("MyController.demoRedirectView,RedirectView完成客户端重定向，由DispatcherServlet根据请求调用");
        return new RedirectView("redirect.jsp");
    }

    //ModelAndView:服务器内部跳转与客户端重定向
    @RequestMapping("demoModelAndView")
    public ModelAndView demoModelAndView(){
        System.out.println("MyController.demoModelAndView,ModelAndView完成服务器内部跳转与客户端重定向，由DispatcherServlet根据请求调用");
        ModelAndView view = new ModelAndView();
        view.addObject("view","流转数据");
//        view.setViewName("modelAndView.jsp");//服务器内部跳转
        view.setViewName("forward:/modelAndView.jsp");//服务器内部跳转
//        view.setViewName("redirect:/modelAndView.jsp");//客户端重定向
        return view;
    }

    //default:服务器内部跳转与客户端重定向
    @RequestMapping("demoDefault")
    public String demoDefault(){
        System.out.println("MyController.demoDefault,完成服务器内部跳转与客户端重定向，由DispatcherServlet根据请求调用");
//        return "default.jsp";//服务器内部跳转
        return "forward:/default.jsp";//服务器内部跳转
//        return "redirect:/default.jsp";//客户端重定向
    }

    //自定义视图解析器
    @RequestMapping("userDefinedView")
    public String userDefinedView(){
        System.out.println("MyController.userDefinedView,自定义视图解析器完成服务器内部跳转，由DispatcherServlet根据请求调用");
        return "userDefinedView";//服务器内部跳转
    }

    //访问WEB-INF里面的资源
    @RequestMapping("readInside")
    public String readInside(){
        System.out.println("MyController.readInside,访问WEB-INF里面的资源");
        return "inside";//服务器内部跳转
    }

    //公共访问WEB-INF里面的资源
    @RequestMapping("{url}")
    public String publicReadInside(@PathVariable String url){
        System.out.println("MyController.publicReadInside,公共访问WEB-INF里面的资源");
        return url;//服务器内部跳转
    }
}
