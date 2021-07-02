package com.test.bean;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service("student")
public class Student implements StudentInterface {

    @Pointcut("execution(* com.test.bean.Student.testStudent())")
    @Override
    public void testStudent() {
        System.out.println("test svc is working");
    }
}