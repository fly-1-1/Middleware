package com.jy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootTest
public class TestBoundAPI {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //为了方便对redis更友好的操作,这里有bound API的使用示例

    @Test
    public void testBound(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

      /*  stringRedisTemplate.opsForValue().set("name","zhangsan");
        stringRedisTemplate.opsForValue().append("name","lisi");
        String s = stringRedisTemplate.opsForValue().get("name");
        System.out.println(s);*/

        //对字符串类型的Key进行绑定 后续所有的操作都是基于这个key操作
        BoundValueOperations<String, String> nameValueOps = stringRedisTemplate.boundValueOps("name");
        nameValueOps.set("wangwu");
        nameValueOps.append("zhangli");
        String s = nameValueOps.get();
        System.out.println(s);

    }

}
