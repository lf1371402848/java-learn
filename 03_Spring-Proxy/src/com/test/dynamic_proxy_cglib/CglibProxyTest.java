package com.test.dynamic_proxy_cglib;


import net.sf.cglib.proxy.Enhancer;

public class CglibProxyTest {
    public static void main(String[] args) {
        //Enhancer创建一个被代理对象的子类并且拦截所有的方法调用
        Enhancer enhancer = new Enhancer();
        //设置父类型
        enhancer.setSuperclass(HelloServiceImpl.class);
        enhancer.setCallback(new CglibProxy());
        //创建代理对象
        HelloServiceImpl proxy = (HelloServiceImpl) enhancer.create();
        proxy.testProxy();
    }
}