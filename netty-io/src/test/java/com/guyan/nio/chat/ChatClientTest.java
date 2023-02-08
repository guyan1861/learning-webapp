package com.guyan.nio.chat;

import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ChatClientTest {

    @Test
    public void test1() throws Exception {
        ChatClient chatClient = new ChatClient();

        new Thread(() -> {
            try {
                chatClient.receiveMsg();
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            chatClient.sendMsg(msg);
        }
    }

    @Test
    public void test2() throws Exception {
        ChatClient chatClient = new ChatClient();

        new Thread(() -> {
            try {
                chatClient.receiveMsg();
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            chatClient.sendMsg(msg);
        }
    }
}