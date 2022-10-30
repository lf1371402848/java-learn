package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2022/9/13 23:56
 * @Version: 1.0
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer8001Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer8001Application.class, args);
    }
}
