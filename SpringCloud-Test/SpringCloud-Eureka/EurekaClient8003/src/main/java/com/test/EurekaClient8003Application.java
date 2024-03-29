package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2022/9/13 23:56
 * @Version: 1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class EurekaClient8003Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClient8003Application.class, args);
    }
}
