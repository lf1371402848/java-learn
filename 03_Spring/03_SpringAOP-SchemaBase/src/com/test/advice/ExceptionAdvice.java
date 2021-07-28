package com.test.advice;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception e){
        System.out.println("ExceptionAdvice.afterThrowing");
    }
}
