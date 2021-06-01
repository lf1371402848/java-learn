package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @EnableFeignClients - 描述当前应用是一个使用Openfeign技术开发的服务消费端。
 *  属性 backPackage - 扫描的包，即使用@FeignClient描述的接口所在包。此属性可省略，默认扫描当前工程所有包。
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.test.service")
public class OpenFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication.class, args);
    }
}
