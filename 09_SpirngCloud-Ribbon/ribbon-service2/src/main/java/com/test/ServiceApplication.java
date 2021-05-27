package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @EnableEurekaClient注解 - 在Spring Cloud低版本开发中，每个Eureka Client应用启动类上都必须增加此注解。
 *  代表当前应用是一个Eureka Client应用，即需要通过Eureka Server注册或发现服务。
 */
@SpringBootApplication
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class,args);
    }
}
