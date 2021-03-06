package com.test;

import com.ribbon.MyIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name="ribbon-service",configuration = MyIRule.class)// name是服务提供者名，configuration是我们配置的负载均衡策略
class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    @LoadBalanced//使用负载均衡机制
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
