package com.guyan.think.in.mybatis.mapper;

import com.guyan.think.in.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public int putUser(User user);

}
