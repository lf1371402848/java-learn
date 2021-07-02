package com.test;

import com.test.bean.StudentInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopAspectj {
    public static void main(String[] args) {
        //获取Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
        StudentInterface stu = (StudentInterface) ac.getBean("student");
        stu.testStudent("李章",18);
    }
}
