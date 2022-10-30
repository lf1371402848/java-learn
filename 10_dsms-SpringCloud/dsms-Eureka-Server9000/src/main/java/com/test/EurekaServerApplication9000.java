package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2021/11/23 22:28
 * @Version: 1.0
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication9000 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication9000.class, args);
    }
}
