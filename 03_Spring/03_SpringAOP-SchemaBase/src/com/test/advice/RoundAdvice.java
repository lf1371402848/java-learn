package com.test.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class RoundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("RoundAdvice.invoke before");
        methodInvocation.proceed();
        System.out.println("RoundAdvice.invoke after");
        return "return RoundAdvice.invoke";
    }
}
