package com.guyan.rpc;

import com.guyan.rpc.consumer.stub.RPCProxy;
import com.guyan.rpc.consumer.SkuService;
import com.guyan.rpc.consumer.UserService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SkuService skuService = (SkuService) RPCProxy.create(SkuService.class);
        System.out.println(skuService.findByName("uid"));
        UserService userService = (UserService) RPCProxy.create(UserService.class);
        System.out.println(userService.findById());

        System.out.println("Hello World!");
    }
}
