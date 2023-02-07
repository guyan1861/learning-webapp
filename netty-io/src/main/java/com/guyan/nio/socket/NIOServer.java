package com.guyan.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @Author: GuYan
 * @Time: 2023/2/7 22:00
 * @Description: 模拟 NIO 服务端
 **/
public class NIOServer {
    public static void main(String[] args) throws IOException {
        // 开启一个服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 开启一个 selector 选择器
        Selector selector = Selector.open();

        System.out.println("服务端 启动....");
        System.out.println("初始化端口 9999 ");
        // 绑定端口号9999
        serverSocketChannel.bind(new InetSocketAddress(9999));
        // 配置非阻塞方式
        serverSocketChannel.configureBlocking(false);
        // Selector选择器注册ServerSocketChannel通道，绑定连接操作
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 循环执行，监听连接操作和读写操作
        while (true) {
            /*
                监听客户端连接
                selector.select()方法返回的是客户端通道数，如果为0，说明客户端没有链接
             */
            if(selector.select(2000) == 0) {
                System.out.println("Server：门庆没有找我，去找王妈妈搞点兼职做~");
                continue;
            }

            // 得到 SelectionKey，判断通道里面的事件
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()) {
                SelectionKey selectionKey = keyIterator.next();
                if(selectionKey.isAcceptable()) {
                    System.out.println("OP_ACCEPT");
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if(selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                    channel.read(byteBuffer);
                    System.out.println("客户端发来数据：" + byteBuffer.array());
                }
                keyIterator.remove();
            }
        }
    }
}
