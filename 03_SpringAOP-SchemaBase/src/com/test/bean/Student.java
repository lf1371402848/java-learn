package com.test.bean;

public class Student implements StudentInterface {

    @Override
    public String testStudent() {
//        int i = 5/0;
        System.out.println("Student.testStudent方法");
        return "testStudent 的无参返回参数";
    }

    @Override
    public String testStudent(String uname, int age) {
        System.out.println("Student.testStudent：uname:" + uname + "age:" + age + "方法");
        return "testStudent 的有参返回参数";
    }
}
