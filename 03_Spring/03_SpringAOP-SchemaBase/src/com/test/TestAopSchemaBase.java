package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.test.bean.StudentInterface;

public class TestAopSchemaBase {
    public static void main(String[] args) {
        //获取Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
        StudentInterface stu = (StudentInterface) ac.getBean("student");
        stu.testStudent();
        stu.testStudent("李章",18);
    }
}
