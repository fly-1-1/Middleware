package com.jy.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class TestKey
{

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
    // 测试key
    public void testKey() {
//        jedis.del("name");
//        //jedis.del("name", "age");
//        Boolean name = jedis.exists("name");
//        System.out.println(name);

        /*Long age1 = jedis.expire("age", 100);
        System.out.println(age1);

        Long age = jedis.ttl("age");
        System.out.println(age);

        String randomedKey = jedis.randomKey();
        System.out.println(randomedKey);

        jedis.rename("age", "age1");*/

        String lists = jedis.type("lists");
        System.out.println(lists);

    }

}
