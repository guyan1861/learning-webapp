package com.guyan.rpc.producer.impl;

import com.guyan.rpc.producer.SkuService;

/**
 * @Author: GuYan
 * @Time: 2023/2/15 21:08
 * @Description: TODO
 **/
public class SkuServiceImpl implements SkuService {
    @Override
    public String findByName(String name) {
        return "sku{}:" + name;
    }
}
