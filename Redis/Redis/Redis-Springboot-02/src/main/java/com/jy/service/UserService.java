package com.jy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends IService<User> {

    public List<User> findAll();

}
