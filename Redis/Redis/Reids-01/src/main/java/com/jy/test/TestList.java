package com.jy.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

public class TestList {

    private Jedis jedis;

    @Before
    public void before(){
        this.jedis = new Jedis("192.168.157.134", 6380);
    }

    @After
    public void after() {
        this.jedis.close();
    }

    @Test
    public void testList() {
        jedis.del("l");
        jedis.lpush("l","a", "b", "c", "d");
        jedis.rpush("l","e", "f", "g", "h");

        List<String> list = jedis.lrange("l", 0, -1);
        list.forEach(System.out::print);

    }
}
