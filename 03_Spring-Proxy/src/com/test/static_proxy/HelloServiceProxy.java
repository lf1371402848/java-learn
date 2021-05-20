package com.test.static_proxy;

import java.util.Date;

public class HelloServiceProxy implements HelloService{
    private HelloService helloService; //表示被代理的HelloService 实例
    
    public HelloServiceProxy(HelloService helloService){
     this.helloService=helloService;
    }
    public Date getTime(){
         System.out.println("before calling getTime()"); //目标方法调前处理
         //调用委托类对象的方法(也就是目标对象方法/被代理对象方法)
         Date date=helloService.getTime();
         System.out.println("after calling getTime()"); //目标方法调用后处理
         return date;
    }
}