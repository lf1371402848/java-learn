package com.test.controller;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//@RestController整合了@Controller与@ResponseBody
public class TestController {
    @Autowired
    private Redisson redisson;

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public Redisson redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setPassword("redis");
        //集群 .setScanInterval(2000)设置心跳检测时间
        //config.useClusterServers().setScanInterval(2000).addNodeAddress("redis://192.6.128:8001","redis://192.6.128:8002","redis://192.6.128:8003");
        return (Redisson) Redisson.create(config);
    }

    @RequestMapping("/kill/{key}")
    @ResponseBody
    public synchronized String kill(@PathVariable String key) {
        //获取锁
//        RLock lock = redisson.getLock(key);
        //上锁
//        lock.lock(30, TimeUnit.SECONDS);
        Object o = redisTemplate.opsForValue().get(key);
        //解锁
//        lock.unlock();
        return "success";
    }
}
