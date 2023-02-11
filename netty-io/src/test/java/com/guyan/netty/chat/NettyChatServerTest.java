package com.guyan.netty.chat;

public class NettyChatServerTest {

    public static void main(String[] args) throws InterruptedException {
        new NettyChatClient("127.0.0.1", 9999).run();
    }
}