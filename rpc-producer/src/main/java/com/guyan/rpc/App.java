package com.guyan.rpc;

import com.guyan.rpc.producer.stub.RPCServer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        new RPCServer(9999).start();
    }
}
