package com.jy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.cache.RedisCache;
import com.jy.entity.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


@Mapper
@CacheNamespace(implementation = RedisCache.class)
public interface UserMapper extends BaseMapper<User>  {

    public List<User> findAll();

}
