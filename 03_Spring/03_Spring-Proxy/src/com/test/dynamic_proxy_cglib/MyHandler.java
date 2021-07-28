package com.test.dynamic_proxy_cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
    private Object target;

    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling getTime()"); //目标方法调前处理
        Object invoke = method.invoke(target, args);
        System.out.println("after calling getTime()"); //目标方法调后处理
        return invoke;
    }
}
