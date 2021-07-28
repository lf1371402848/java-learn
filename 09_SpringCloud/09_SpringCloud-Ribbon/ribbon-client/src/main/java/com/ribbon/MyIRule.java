package com.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

public class MyIRule {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();//这里配置策略，和配置文件对应
    }
}