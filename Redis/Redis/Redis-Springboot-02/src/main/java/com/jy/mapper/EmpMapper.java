package com.jy.mapper;

import com.jy.cache.RedisCache;
import com.jy.entity.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jy
 * @since 2024-06-10
 */

@CacheNamespaceRef(UserMapper.class)
public interface EmpMapper extends BaseMapper<Emp> {

}
