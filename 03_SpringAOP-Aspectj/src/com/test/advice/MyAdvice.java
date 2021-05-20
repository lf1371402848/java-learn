package com.test.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {

    //前置通知
    public void before(String name, int age) {
        System.out.println("MyAdvice.before:我是前置通知" + "name=" + name + "age=" + age);
    }

    //后置通知
    public void after(String name, int age) {
        System.out.println("MyAdvice.after:我是后置通知" + "name=" + name + "age=" + age);
    }

    //环绕通知
    public void round(ProceedingJoinPoint pp) throws Throwable {
        System.out.println("MyAdvice.round:我是环绕通知前");
        pp.proceed();
        System.out.println("MyAdvice.round:我是环绕通知后");
    }

    //异常通知
    public void exception(Exception e) {
        System.out.println("MyAdvice.exception:我是异常通知" + e.getMessage());
    }
}
