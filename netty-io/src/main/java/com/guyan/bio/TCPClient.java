package com.guyan.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: GuYan
 * @Time: 2023/2/7 20:22
 * @Description: 模拟 TCP 客户端
 **/
public class TCPClient {
    public static void main(String[] args) throws IOException {
        while (true) {
            // 建立客户端程序
            Socket socket = new Socket("127.0.0.1", 9999);
            OutputStream os = socket.getOutputStream();
            // 客户端输入信息
            System.out.println("请输入信息");
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.nextLine();
            // 发送消息
            os.write(msg.getBytes());
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[10];
            is.read(bytes);
            System.out.println("老板说：" + new String(bytes));
            socket.close();
        }
    }
}
