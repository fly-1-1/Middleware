package com.jy;

import org.apache.ibatis.annotations.CacheNamespace;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.jy.mapper")
public class RedisSpringboot02Application {

	public static void main(String[] args) {
		SpringApplication.run(RedisSpringboot02Application.class, args);
	}

}
