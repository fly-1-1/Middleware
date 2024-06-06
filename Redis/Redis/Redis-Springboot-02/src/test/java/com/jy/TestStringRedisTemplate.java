package com.jy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = RedisSpringboot02Application.class)
public class TestStringRedisTemplate {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testKey() {
        stringRedisTemplate.delete("name");
        Boolean name = stringRedisTemplate.hasKey("name");
        System.out.println(name);
        stringRedisTemplate.opsForValue().set("name", "zs");
        DataType name1 = stringRedisTemplate.type("name");
        System.out.println(name);
        Set<String> keys = stringRedisTemplate.keys("*");
        System.out.println(keys);

        Long name2 = stringRedisTemplate.getExpire("name");
        System.out.println(name2);

    }

    @Test
    public void testString() {
        stringRedisTemplate.opsForValue().set("name", "zs");
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);

        stringRedisTemplate.opsForValue().set("code", "1234", 120, TimeUnit.SECONDS);
        stringRedisTemplate.opsForValue().append("name", "他是一个好人");

    }

    @Test
    public void testList() {
        stringRedisTemplate.opsForList().leftPush("list", "1");
        stringRedisTemplate.opsForList().leftPushAll("list", "1", "2", "3");
        //遍历
        System.out.println(stringRedisTemplate.opsForList().range("list", 0, -1));

    }

    @Test
    public void testSet() {

        stringRedisTemplate.opsForSet().add("sets", "1", "2", "2");
        System.out.println(stringRedisTemplate.opsForSet().members("sets"));
    }

    @Test
    public void testZSet() {
        stringRedisTemplate.opsForZSet().add("zsets", "1", 1);
        stringRedisTemplate.opsForZSet().add("zsets", "2", 2);
        stringRedisTemplate.opsForZSet().add("zsets", "3", 3);
        //System.out.println(stringRedisTemplate.opsForZSet().range("zsets", 0, -1));
        Set<ZSetOperations.TypedTuple<String>> zsets = stringRedisTemplate.opsForZSet().rangeByScoreWithScores("zsets", 0, 10);
        zsets.forEach(typedTuple -> {
            System.out.println(typedTuple.getValue() + ":" + typedTuple.getScore());
        });
    }

    @Test
    public void testHash() {
        stringRedisTemplate.opsForHash().put("maps", "name", "zs");
        stringRedisTemplate.opsForHash().put("maps", "age", "18");

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        stringRedisTemplate.opsForHash().putAll("maps", map);
        stringRedisTemplate.opsForHash().get("maps", "name");
        stringRedisTemplate.opsForHash().values("maps").forEach(System.out::print);
        System.out.println();
        stringRedisTemplate.opsForHash().keys("maps").forEach(System.out::print);

    }

}
