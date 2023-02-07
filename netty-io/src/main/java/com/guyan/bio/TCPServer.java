package com.guyan.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: GuYan
 * @Time: 2023/2/7 20:10
 * @Description: 模拟 TCP 服务器
 **/
public class TCPServer {
    public static void main(String[] args) throws IOException {
        // 初始化一个ServerSocket
        System.out.println("服务端启动.......");
        System.out.println("服务端监听端口9999");
        // 监听端口
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            // 监听客户端 阻塞
            Socket accept = serverSocket.accept();
            InputStream is = accept.getInputStream();
            byte[] bytes = new byte[10];
            is.read(bytes);
            // 打印客户端发送的信息
            System.out.println("ClientIP " + serverSocket.getInetAddress().getHostAddress() + "说：" + new String(bytes).trim());
            OutputStream os = accept.getOutputStream();
            // 回复客户端信息
            os.write("没钱".getBytes());
            // 关闭
            accept.close();
        }
    }
}
