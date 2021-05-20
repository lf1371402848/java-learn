package com.test.controller;

import com.test.bean.Student;
import com.test.bean.Teacher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyController {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        Student student1 = (Student) context.getBean("student_by_default");
        System.out.println("无参构造器默认方式注入方式创建对象："+ student1);

        Student student2 = (Student) context.getBean("student_by_constructor");
        System.out.println("有参构造器注入方式创建对象："+ student2);

        Student student3 = (Student) context.getBean("student_by_property");
        System.out.println("属性注入方式创建对象："+ student3);

        Student student4 = (Student) context.getBean("student_by_factory");
        System.out.println("动态工厂方式创建对象："+ student4);

        Student student5 = (Student) context.getBean("student_by_staticFactory");
        System.out.println("静态工厂方式创建对象："+ student5);

        Student student6 = (Student) context.getBean("student_by_di");
        System.out.println("依赖注入方式创建对象："+ student6);

        Student student7 = (Student) context.getBean("student_by_AutoName");
        System.out.println("自动注入byName方式创建对象："+ student7);
        Teacher teacher1 = (Teacher) context.getBean("teacher_by_auto");
        System.out.println("自动注入byName方式创建对象："+ teacher1);

        Student student8 = (Student) context.getBean("student_by_AutoType");
        System.out.println("自动注入byType方式创建对象："+ student8);
        Teacher teacher2 = (Teacher) context.getBean("teacher_by_auto");
        System.out.println("自动注入byType方式创建对象："+ teacher2);

        Student student9 = (Student) context.getBean("student_by_AutoConstructor");
        System.out.println("自动注入constructor方式创建对象："+ student9);
    }
}
