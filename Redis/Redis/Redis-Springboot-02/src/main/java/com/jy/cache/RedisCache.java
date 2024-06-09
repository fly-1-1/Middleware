package com.jy.cache;

import com.jy.util.ApplicationContextUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.DigestUtils;

import java.util.concurrent.TimeUnit;

public class RedisCache implements Cache {

    //当前放入缓存的mapper的namespace
    private final String id;

    public RedisCache(String id) {
        System.out.println("id:" + id);
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {

        System.out.println("key = " + key + ", value = " + value);
        //redis中的hash缓存
        getRedisTemplate().opsForHash().put(getKey2Md5(this.id.toString()), key.toString(), value);


        if (id.equals("com.jy.mapper.UserMapper")){
            getRedisTemplate().expire(id.toString(),1, TimeUnit.MINUTES);
        }
    }

    @Override
    public Object getObject(Object key) {


        return getRedisTemplate().opsForHash().get(id.toString(),getKey2Md5(key.toString()));
    }

    @Override
    public Object removeObject(Object key) {
        System.out.println("根据指定的key删除缓存");
        return null;
    }

    @Override
    public void clear() {
        getRedisTemplate().delete(id.toString());
        System.out.println("清空缓存");
    }

    @Override
    public int getSize() {
        return 0;
    }

    private RedisTemplate getRedisTemplate() {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    //封装一个对key进行md5加密的工具方法
    private String getKey2Md5(String key){
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }


}
