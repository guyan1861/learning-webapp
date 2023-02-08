package com.guyan.nio.chat;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: GuYan
 * @Time: 2023/2/8 20:57
 * @Description: TODO
 **/
public class ChatClientTest {
    public static void main(String[] args) throws Exception {
        ChatClient chatClient = new ChatClient();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                2, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        threadPoolExecutor.submit(() -> {
            while (true) {
                try {
                    chatClient.receiveMsg();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            chatClient.sendMsg(msg);
        }
    }
}
