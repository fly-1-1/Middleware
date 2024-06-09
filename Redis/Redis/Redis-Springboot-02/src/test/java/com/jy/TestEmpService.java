package com.jy;


import com.jy.entity.Emp;
import com.jy.service.IEmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
public class TestEmpService {


    @Autowired
    private IEmpService empService;

    @Test
    public void test(){
        empService.list().forEach(System.out::println);
        System.out.println("=============");
        empService.list().forEach(System.out::println);
    }

    @Test
    public void testMd5(){
        String key="1860238455:4679889258:com.jy.mapper.EmpMapper.selectList:0:2147483647:SELECT  id,name  FROM emp:MybatisSqlSessionFactoryBean";
        String string = DigestUtils.md5DigestAsHex(key.getBytes());
        System.out.println(string);
    }

}
