package com.test.controller;

import com.test.bean.Student;
import com.test.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2022/8/23 23:19
 * @Version: 1.0
 */

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("findAll")
    public String findAll(HttpSession session){
        List<Student> studentList = studentService.findAll();
        session.setAttribute("studentList",studentList);
        return "success";
    }
}
