package com.test.bean;

public class StudentFactory {
    public Student newIntance(){
        //声明Student对象创建的其他依赖资源
        System.out.println("我是动态工厂");
        return  new Student();
    }
}
