package com.test.interceptor;

import com.test.controller.MyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    拦截器，拦截器资源是DispatcherServlet调用的
    过滤器是在DispatcherServlet之前调用，拦截器是在DispatcherServlet之后,单元方法之前调用的
*/
public class MyInterceptor implements HandlerInterceptor{

    @Autowired
    private MyController myController;

    /**
     * @apiNote:在DispatcherServlet之后,单元方法之前调用
     * @apiNote:return_false后要声明响应的内容，因为拦截成功后DispatcherServlet不会调用单元方法进行响应，也不会执行后续方法。
     * @return: true:放行 false:拦截
     * @param request:此次请求对象
     * @param response:此次响应对象
     * @param handler:此次请求的单元方法HandlerMethod的实例化对象
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor.preHandle");
        //作用1、放行后过滤业务代码
        //...
        //作用2、拦截后用response响应
        response.getWriter().write("request has been intercepted");
        //作用3、拦截后通过反射调用方法
        /*HandlerMethod methodMethod = (HandlerMethod) handler;
        Method method = methodMethod.getMethod();
        method.invoke(myController,null);*/
        return true;
    }

    /**
     * @apiNote:单元方法之后，单元方法return之前调用
     * @return: true:放行 false:拦截
     * @param request:此次请求对象
     * @param response:此次响应对象
     * @param handler:此次请求的单元方法HandlerMethod的实例化对象
     * @param modelAndView:modelAndView对象
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor.postHandle");
        //作用1、修改请求的数据
        request.setAttribute("str","拦截完成");
        //作用2、修改return的资源路径
        modelAndView.setViewName("forward:/bb.jsp");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor.afterCompletion");
    }
}
