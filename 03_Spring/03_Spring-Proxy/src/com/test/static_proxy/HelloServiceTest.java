package com.test.static_proxy;

public class HelloServiceTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService helloServiceProxy = new HelloServiceProxy(helloService);
        System.out.println(helloServiceProxy.getTime());
    }
}