package com.test.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyAdvice {

    // 拦截，打印日志，并且通过JoinPoint 获取方法参数
    @Before("com.test.bean.Student.testStudent()")
    public void before(JoinPoint joinPoint) {
        System.out.println("在service 方法执行前 打印第 1 次日志");
        System.out.println("拦截的service 方法的方法签名: " + joinPoint.getSignature());
        System.out.println("拦截的service 方法的方法入参: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* com.test.bean.Student.testStudent())")
    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("在service 方法执行后 打印第 1 次日志");
        System.out.println("拦截的service 方法的方法签名: " + joinPoint.getSignature());
        System.out.println("拦截的service 方法的方法入参: " + Arrays.toString(joinPoint.getArgs()));
    }
}
