package com.test.controller;

import com.test.bean.Student;
import com.test.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private IStudentService studentService;

    @RequestMapping("/testList")
    @ResponseBody
    public List<Student> testList(){
        System.out.println("TestController.sayHello");
        return studentService.findAllStudents();
    }

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(){
        System.out.println("TestController.testJsp");
        return "testThymeleaf";
    }

    @RequestMapping("/testListThymeleaf")
    public String testListJsp(HttpServletRequest request){
        System.out.println("TestController.testListJsp");
        List<Student> list = studentService.findAllStudents();
        for (Student student : list) {
            System.out.println(student);
        }
        request.setAttribute("student",list);
        return "testListThymeleaf";
    }
}
