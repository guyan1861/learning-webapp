package com.guyan.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author: GuYan
 * @Time: 2023/2/7 22:00
 * @Description: 模拟 NIO 客户端
 **/
public class NIOClient {
    public static void main(String[] args) throws IOException {
        // 1.得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        // 2.设置非阻塞方式
        socketChannel.configureBlocking(false);
        // 连接服务端
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
        // 连接服务端
        if(!socketChannel.connect(address)) {
            // 连接失败，改用 while 循环重试
            while (!socketChannel.finishConnect()) {
                // 提现异步做一些事情
                System.out.println("Client:连接金莲的时候,还可以做一些别的事情！！！！！！");
            }
        }

        String msg = "金莲呀！大郎在吗？我想进来！！！";
        // 初始化一个 buffer
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        // buffer 中数据写到通道
        socketChannel.write(buffer);

        // 组织客户端终止，否则服务端也会停止
        System.in.read();

    }
}
