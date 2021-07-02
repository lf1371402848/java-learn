package com.test.dynamic_proxy_jdk;

import java.lang.reflect.Proxy;

public class JdkProxyTest {
    public static void main(String[] args) {
        HelloServiceImpl target = new HelloServiceImpl();
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        HelloService proxy = (HelloService) Proxy.newProxyInstance(classLoader,interfaces,new MyHandler(target));
        proxy.testProxy();
    }
}