package com.test.controller;

import com.test.bean.Student;
import com.test.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//@RestController整合了@Controller与@ResponseBody
public class TestController {
    @Autowired
    private IStudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/hello")
    public List<Student> sayHello(){
        logger.info("logback begin");
        System.out.println("TestController.sayHello");
        return studentService.findAllStudents();
    }

    @GetMapping("/index")
    public String index(){
        System.out.println("TestController.index");
        return "index";
    }
}
