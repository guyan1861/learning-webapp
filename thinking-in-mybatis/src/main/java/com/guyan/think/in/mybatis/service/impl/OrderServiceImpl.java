package com.guyan.think.in.mybatis.service.impl;

import com.guyan.think.in.mybatis.gen.OrderMapper;
import com.guyan.think.in.mybatis.pojo.Order;
import com.guyan.think.in.mybatis.service.OrderService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;

    @Override
    public Integer putOrder(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public Integer insertSelective(Order order) {
        return orderMapper.insertSelective(order);
    }

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public Order getOrder() {
        Order order = orderMapper.selectByPrimaryKey(1);
        return order;
    }
}
