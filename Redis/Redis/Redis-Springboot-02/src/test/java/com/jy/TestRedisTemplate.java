package com.jy;

import com.jy.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Date;

@SpringBootTest
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;



    @Test
    public void testRedisTemplate(){
       /* User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setBir(new Date());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set("user",user);
        User user1 =(User) redisTemplate.opsForValue().get("user");
        System.out.println(user1);
        RedisSerializer keySerializer = redisTemplate.getKeySerializer();*/

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForHash().put("usermap", "name", "张三");
    }

}
