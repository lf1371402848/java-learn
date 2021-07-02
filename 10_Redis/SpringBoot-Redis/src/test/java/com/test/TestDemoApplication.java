package com.test;

import com.test.pojo.Student;
import com.test.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {DemoApplication.class})
@RunWith(SpringRunner.class)
public class TestDemoApplication {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("test", "test");
        System.out.println(redisTemplate.opsForValue().get("test"));
    }

    @Test
    public void test1(){
        Student s = new Student("lf", 24);
        redisTemplate.opsForValue().set("student",s);
        System.out.println(redisTemplate.opsForValue().get("student"));
    }

    @Test
    public void test2(){
        redisUtil.set("easy", "easy");
    }
}
