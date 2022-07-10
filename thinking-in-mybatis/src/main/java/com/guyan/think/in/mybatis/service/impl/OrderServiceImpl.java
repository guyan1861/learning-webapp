package com.guyan.think.in.mybatis.service.impl;

import com.guyan.think.in.mybatis.mapper.OrderMapper;
import com.guyan.think.in.mybatis.pojo.Order;
import com.guyan.think.in.mybatis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;

    @Override
    public Integer putOrder(Order order) {
        return orderMapper.putOrder(order);
    }

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }
}
