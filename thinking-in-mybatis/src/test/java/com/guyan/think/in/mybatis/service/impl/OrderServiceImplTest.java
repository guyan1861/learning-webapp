package com.guyan.think.in.mybatis.service.impl;

import com.guyan.think.in.ThinkingInMybatisApplication;
import com.guyan.think.in.mybatis.pojo.Order;
import com.guyan.think.in.mybatis.pojo.User;
import com.guyan.think.in.mybatis.service.OrderService;
import com.guyan.think.in.mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ThinkingInMybatisApplication.class)
class OrderServiceImplTest {

    private UserService userService;
    private OrderService orderService;

    @Test
    void putOrder() {
        Order order = new Order();
        order.setOrderName("糕点");
        order.setOrderNumber(11);
        User user = userService.getUser(2);
        order.setUserId(user.getId());
        order.setNote(user.getUsername() + "在" + user.getAddress() + ",太好吃了，人间美味！");
        orderService.putOrder(order);
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    void getOrder() {
        Order order = orderService.getOrder();
        System.out.println(order);
    }

    @Test
    void insertSelective() {
        Order order = new Order();
        order.setOrderName("水果");
        order.setOrderNumber(15);
        User user = userService.getUser(3);
        order.setUserId(user.getId());
        order.setNote(user.getUsername() + "在" + user.getAddress() + ",我要多买点！");
        orderService.insertSelective(order);
    }
}