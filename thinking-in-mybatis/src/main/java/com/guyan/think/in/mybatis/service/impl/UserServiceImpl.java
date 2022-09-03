package com.guyan.think.in.mybatis.service.impl;

import com.guyan.think.in.mybatis.gen.UserMapper;
import com.guyan.think.in.mybatis.pojo.User;
import com.guyan.think.in.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public Integer putUser(User user) {
        return userMapper.insert(user);
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUser(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }
}
