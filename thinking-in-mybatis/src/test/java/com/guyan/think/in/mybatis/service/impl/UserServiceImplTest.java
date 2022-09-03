package com.guyan.think.in.mybatis.service.impl;

import com.guyan.think.in.ThinkingInMybatisApplication;
import com.guyan.think.in.mybatis.pojo.User;
import com.guyan.think.in.mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ThinkingInMybatisApplication.class)
public class UserServiceImplTest {

    public UserService service;

    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("向问天");
        user.setAddress("黑木崖");
        service.putUser(user);
    }

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

}