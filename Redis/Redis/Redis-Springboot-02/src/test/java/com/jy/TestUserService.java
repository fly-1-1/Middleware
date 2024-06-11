package com.jy;

import com.jy.entity.User;
import com.jy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void test() {

        userService.list().forEach(user -> System.out.println(user.toString()));

        System.out.println("=====================");

        userService.list().forEach(user -> System.out.println(user.toString()));

    }

    @Test
    public void testById() {

        userService.getById(1);

         userService.getById(1);

    }

    @Test
    public void testDel() {

        userService.removeById(1);

    }

    @Test
    public void testSave() {
        User user = new User();
        user.setName("wangwu");
        user.setAge(20);
        user.setBir(new Date());
        userService.save(user);
    }


    @Test
    public void testUpdate() {
        User user=new User();
        user.setId("1");
        user.setName("lisi11");
        userService.updateById(user);
    }



}
