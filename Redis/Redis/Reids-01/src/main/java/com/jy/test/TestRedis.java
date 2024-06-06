package com.jy.test;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestRedis {

    public static void main(String[] args) {
        //创建jedis客户端对象
        Jedis jedis = new Jedis("192.168.157.134", 6380);

        //选择使用库
        jedis.select(0);
        
        //获取所有的key信息
        Set<String> keys = jedis.keys("*");
        keys.forEach(System.out::println);

        //操作相关
        jedis.flushAll();
        jedis.flushDB();

        //释放连接
        jedis.close();
    }

}


