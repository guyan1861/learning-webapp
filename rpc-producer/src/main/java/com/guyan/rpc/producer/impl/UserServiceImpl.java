package com.guyan.rpc.producer.impl;

import com.guyan.rpc.producer.UserService;

/**
 * @Author: GuYan
 * @Time: 2023/2/15 21:10
 * @Description: TODO
 **/
public class UserServiceImpl implements UserService {
    @Override
    public String findById() {
        return "{id=1,name=guyan}";
    }
}
