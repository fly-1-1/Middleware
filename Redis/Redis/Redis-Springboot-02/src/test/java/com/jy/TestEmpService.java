package com.jy;


import com.jy.entity.Emp;
import com.jy.service.IEmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
