package com.jy.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

public class TestString {

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
    public void testString() {
        jedis.set("name", "jingyuan");
        String name = jedis.get("name");
        System.out.println(name);


        jedis.mset("name", "jingyuan", "age", "25", "gender", "male");
        List<String> mget = jedis.mget("name", "age", "gender");
        System.out.println(mget);

        String set = jedis.getSet("name", "jingyuan1");
        System.out.println(set);
    }
}
