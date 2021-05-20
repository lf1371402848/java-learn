package com.test.dynamic_proxy_jdk;

public class HelloServiceImpl implements HelloService {

    @Override
    public void testProxy() {
        System.out.println("HelloServiceImpl.testProxy:真实对象方法");
    }
}