package com.guyan.think.in.mybatis.mapper;

import com.guyan.think.in.mybatis.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public Integer putOrder(Order order);
}
