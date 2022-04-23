package com.guyan.think.in.mybatis.pojo;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private String orderName;
    private String orderNumber;
    private Integer userId;
    private String note;
}
