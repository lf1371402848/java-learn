package com.test;

import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

public class TestMain {
    public static void main(String[] args) {
        testStandalone();
        testPool();
//        testCluster();
    }

    //单机
    public static void testStandalone() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("redis");
        jedis.select(0);
        //查看服务是否运行
        System.out.println("Server is running: " + jedis.ping());
        jedis.set("name", "lf");
        System.out.println(jedis.get("name"));
    }


    //连接池
    public static void testPool() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(20);
        poolConfig.setMaxIdle(5);
        poolConfig.setMinIdle(3);
        //连接Redis服务
        JedisPool jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379);
        //获取Redis连接
        Jedis jedis = jedisPool.getResource();
        //设置密码
        jedis.auth("redis");
        jedis.set("name", "lf");
        System.out.println(jedis.get("name"));
    }

    //集群
    public static void testCluster() {
        Set<HostAndPort> set = new HashSet<>();
        set.add(new HostAndPort("127.0.0.1", 7001));
        set.add(new HostAndPort("127.0.0.1", 7002));

        // Jedis连接池配置
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大空闲连接数, 默认8个
        poolConfig.setMaxIdle(100);
        // 最大连接数, 默认8个
        poolConfig.setMaxTotal(500);
        //最小空闲连接数, 默认0
        poolConfig.setMinIdle(0);
        // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        poolConfig.setMaxWaitMillis(2000); // 设置2秒
        //对拿到的connection进行validateObject校验
        poolConfig.setTestOnBorrow(true);

        JedisCluster jedisCluster = new JedisCluster(set, 10, 10, 5, "redis", poolConfig);
        jedisCluster.set("name", "lf");
        System.out.println(jedisCluster.get("name"));
    }
}
