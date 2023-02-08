package com.guyan.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @Author: GuYan
 * @Time: 2023/2/8 20:00
 * @Description:
 **/
public class ChatClient {
    private final static String HOST = "127.0.0.1";
    private SocketChannel socketChannel;
    private final static int PORT = 9999;
    private String userName;

    public ChatClient() throws IOException {
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress address = new InetSocketAddress(HOST, PORT);
        if(!socketChannel.connect(address)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("Client:连接服务器端的同时，咱也别闲着，去搞点兼 职~");
            }
        }
        userName = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println("---------------Client(" + userName + ") is ready---------------");
    }

    public void sendMsg(String msg) throws Exception {
        if("bye".equalsIgnoreCase(msg)) {
            socketChannel.close();
            return;
        }
        msg = userName + "说：" + msg;
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        socketChannel.write(buffer);
    }

    public void receiveMsg() throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        int size = socketChannel.read(buffer);
        if(size > 0) {
            String msg = new String(buffer.array());
            System.out.println(msg.trim());
        }
    }

    public static void main(String[] args) throws Exception {
        ChatClient chatClient = new ChatClient();

        new Thread(() -> {
            while (true) {
                try {
                    chatClient.receiveMsg();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            chatClient.sendMsg(msg);
        }
    }
}
