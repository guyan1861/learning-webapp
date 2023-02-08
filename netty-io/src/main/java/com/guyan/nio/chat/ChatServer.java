package com.guyan.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * @Author: GuYan
 * @Time: 2023/2/8 20:00
 * @Description: TODO
 **/
public class ChatServer {

    private ServerSocketChannel listenerChannel;
    private Selector selector;
    private static final int PORT = 9999;

    public ChatServer() {
        try {
            // 建立一个通道
            listenerChannel = ServerSocketChannel.open();
            // 打开选择器
            selector = Selector.open();
            // 绑定端口
            listenerChannel.bind(new InetSocketAddress(PORT));
            listenerChannel.configureBlocking(false);
            // 选择器注册到通道上
            listenerChannel.register(selector, SelectionKey.OP_ACCEPT);
            printInfo("真人网络聊天室 启动.......");
            printInfo("真人网络聊天室 初始化端口 9999.......");
            printInfo("真人网络聊天室 初始化网络ip地址 121.199.163.228.......");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() throws IOException {
        try {
            // 循环监听
            while (true) {
                if(selector.select(2000) == 0) {
                    System.out.println("Server:没有客户端连接，我去搞点兼职");
                    continue;
                }
                //
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()) {
                        SocketChannel sc = listenerChannel.accept();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ);
                        System.out.println(sc.getRemoteAddress().toString().substring(1) + "上线 了...");
                    }
                    if(key.isReadable()) {
                        readMsg(key);
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readMsg(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        int count = channel.read(byteBuffer);
        if(count > 0) {
            String msg = new String(byteBuffer.array());
            // 打印消息
            printInfo(msg);
            // 全员广播消息
            broadCast(channel, msg);
        }

    }

    private void broadCast(SocketChannel channel, String msg) throws IOException {
        System.out.println("服务器广播了消息...");
        for (SelectionKey key : selector.keys()) {
            Channel targetChannel = key.channel();
            if(targetChannel instanceof SocketChannel && targetChannel != channel) {
                SocketChannel destChannel = (SocketChannel) targetChannel;
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                destChannel.write(buffer);
            }
        }
    }

    private void printInfo(String s) {
        // 打印信息到控制台
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("[" + sdf.format(new Date()) + "] -> " + s);
    }

    public static void main(String[] args) throws IOException {
        new ChatServer().start();
    }

}
