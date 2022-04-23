package com.guyan.think.in.mybatis.service;

import com.guyan.think.in.mybatis.pojo.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    public Integer putOrders(List<Order> orderList);
}
