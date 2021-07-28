package com.test.controller;

import com.test.bean.Student;
import com.test.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//@RestController整合了@Controller与@ResponseBody
public class TestController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/hello")
    public List<Student> sayHello(){
        System.out.println("TestController.sayHello");
        return studentService.findAllStudents();
    }

    @GetMapping("/index")
    public String index(){
        System.out.println("TestController.index");
        return "index";
    }
}
