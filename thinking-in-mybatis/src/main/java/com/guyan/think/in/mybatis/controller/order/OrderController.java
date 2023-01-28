package com.guyan.think.in.mybatis.controller.order;

import com.guyan.think.in.mybatis.pojo.Order;
import com.guyan.think.in.mybatis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    private OrderService orderService;

    @PostMapping("/order/putOrder")
    public Map<String, String> putOrder(Order order) {
        Map<String, String> map = new HashMap<>();
        if (order != null) {
            Integer orders = orderService.putOrder(order);
            map.put("success", "创建订单：" + orders + "个");
        } else {
            map.put("error", "传输的数据有问题，请检查！");
        }
        return map;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
