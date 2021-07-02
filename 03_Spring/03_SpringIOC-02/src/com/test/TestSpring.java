package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring容器对象在完成mybatis相关对象的创建后，
 * 会自动的调用其完成mapper层的扫描，将扫描结果
 * 也就是mapper接口的实例化对象，再次存储到Spring
 * 容器对象中，资源的键名默认为mapper接口的首字母小写
 */
public class TestSpring {
    public static void main(String[] args) {
        //获取Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
        //返回spring容器中所有的bean对象的键名
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("--------------" + name + "--------------");
        }

    }
}
