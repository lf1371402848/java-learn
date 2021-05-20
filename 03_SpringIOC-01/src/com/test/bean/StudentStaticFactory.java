package com.test.bean;

public class StudentStaticFactory {
    public static Student newIntance(){
        //声明Student对象创建的其他依赖资源
        System.out.println("我是静态工厂");
        return  new Student();
    }
}
