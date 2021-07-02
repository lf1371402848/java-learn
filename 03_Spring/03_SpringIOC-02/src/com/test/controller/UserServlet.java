package com.test.controller;

import com.test.bean.User;
import com.test.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/userLogin", loadOnStartup = 1)
public class UserServlet extends HttpServlet {
    //声明变量记录业务层对象
    private UserService userService;

    //初始化方法，在Servlet被初始化创建的时候触发。
    @Override
    public void init() throws ServletException {
        //创建Spring容器对象
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        userService = (UserService) ac.getBean("us");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");

        //设置响应编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        //处理请求
        //调用业务层方法
        User user = userService.userLoginService(uname, pwd);
        //响应结果
        //获取session对象
        HttpSession session = req.getSession();
        if (user != null) {
            session.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/main.jsp");//登录成功重定向到主页
        } else {
            session.setAttribute("flag", "loginFail");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");//登录失败重定向到登录页面
        }
    }
}
