package com.test;

import com.test.bean.StudentInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopAspectj {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        StudentInterface svc = (StudentInterface) context.getBean("student");
        svc.testStudent();
    }
}