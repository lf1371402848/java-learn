package com.test.controller;

import com.test.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 控制器类
 */
@Controller
public class MyController {

    //声明请求处理的逻辑方法(单元方法)
    @RequestMapping("demo")
    public String demo() {
        System.out.println("我是处理请求的逻辑单元方法，由DispatcherServlet根据请求调用");
        return "index.jsp";
    }

    @RequestMapping("req_by_request")
    public String req_by_request(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("MyController.req_by_request:我是紧耦合方式获取请求数据---" + "name:" + name + ",age:" + age);
        return "index.jsp";
    }

    @RequestMapping("req_by_restful_same/{name}/{age}")
    public String req_by_restful_same(@PathVariable String name, @PathVariable int age) {
        System.out.println("MyController.req_by_restful_same:我是restful格式解耦合方式获取请求数据，请求数据键名和单元方法形参名一致--" + "name:" + name + ",age:" + age);
        return "index.jsp";
    }

    @RequestMapping("req_by_restful_not_same/{sname}/{age}")
    public String req_by_restful(@PathVariable("sname") String name, @PathVariable("age")int age) {
        System.out.println("MyController.req_by_restful_not_same:我是restful格式解耦合方式获取请求数据，请求数据键名和单元方法形参名不一致--" + "name:" + name + ",age:" + age);
        return "index.jsp";
    }

    @RequestMapping("req_by_param_same")
    public String req_by_param_same(String name, int age) {
        System.out.println("MyController.req_by_param_same:我是解耦合方式获取请求数据，请求数据键名和单元方法形参名一致--" + "name:" + name + ",age:" + age);
        return "index.jsp";
    }

    @RequestMapping("req_by_param_not_same")
    public String req_by_param_not_same(@RequestParam("name") String sname, @RequestParam("age") int sage) {
        System.out.println("MyController.req_by_param_not_same:我是解耦合方式获取请求数据,请求数据键名和单元方法形参名不一致--" + "name:" + sname + ",age:" + sage);
        return "index.jsp";
    }

    @RequestMapping("req_by_object")
    public String req_by_object(Student student) {
        System.out.println("MyController.req_by_object:我是解耦合方式获取请求数据,请求数据使用实体类对象接收--" + student);
        return "index.jsp";
    }

    @RequestMapping("req_get_same_key_many_value")
    public String req_get_same_key_many_value(String name, Integer age, String[] fav) {
        System.out.println("MyController.req_get_same_key_many_value:我是解耦合方式获取请求数据,获取同键不同值的请求数据:" + "name:" + name + ",age:" + age + Arrays.deepToString(fav));
        return "index.jsp";
    }

    @RequestMapping("req_by_mix")
    public String req_by_mix(Student student, String name, String[] fav, HttpServletRequest request) {
        System.out.println("MyController.req_by_mix:我是获取请求数据方式紧耦合解耦合方式混合使用:" + student + ",name:" + name + ",fav:" + Arrays.deepToString(fav) + ",name:" + request.getParameter("name"));
        return "index.jsp";
    }
}
