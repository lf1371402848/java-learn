package com.test.controller;

import com.test.bean.Student;
import com.test.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 控制器类
 */
@Controller
public class MyController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("demo")
    public String demo(HttpServletRequest request){
        System.out.println("我是处理请求的逻辑单元方法，由DispatcherServlet根据请求调用");
        List<Student> list = studentService.findAllStudents();
        for (Student student : list) {
            System.out.println(student);
        }
        request.setAttribute("student",list);
        return "aa";
    }


}
