package com.test.bean;

public class Student implements StudentInterface {

    @Override
    public String testStudent(String name, int age) {
        System.out.println("Student.testStudent：name:" + name + "age:" + age + "方法");
        return "testStudent 的有参返回参数";
    }
}
