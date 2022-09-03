package com.guyan.think.in.mybatis.service;

import com.guyan.think.in.mybatis.pojo.User;
import org.springframework.stereotype.Service;

public interface UserService {
    public Integer putUser(User user);

    public User getUser(Integer userId);

}
