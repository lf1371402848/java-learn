package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2022/9/23 1:27
 * @Version: 1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class LagouCloudGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(LagouCloudGatewayApplication.class, args);
    }
}