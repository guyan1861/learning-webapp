package com.guyan.nio.file;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: GuYan
 * @Time: 2023/2/7 20:58
 * @Description: 测试 NIO
 **/
public class TestNIO {
    @Test
    public void test1() throws IOException {
        // 创建输出流
        FileOutputStream fs = new FileOutputStream("basic1.txt");
        // 从流中得到一个通道
        FileChannel channel = fs.getChannel();
        // 提供一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 向缓冲区里写数据
        byteBuffer.put("Hello NIO".getBytes());
        // 缓冲区反转，才能把数据写到文件
        byteBuffer.flip();
        // 写文件到缓冲区
        channel.write(byteBuffer);
        // 关闭文件流
        fs.close();
    }

    @Test
    public void test2() throws IOException {
        // 读取文件
        File file = new File("basic1.txt");
        // 从流中得到一个通道
        FileInputStream fis = new FileInputStream(file);
        FileChannel channel = fis.getChannel();
        // 提供一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        // 读数据到 buffer 中
        channel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
        // 关闭
        channel.close();
    }

    @Test
    public void test3() throws IOException {
        FileInputStream fis = new FileInputStream("basic.txt");
        FileOutputStream fos = new FileOutputStream("basic3.txt");
        byte[] bytes = new byte[1024];
        while (true) {
            int res = fis.read(bytes);
            if(res == -1) {
                break;
            }
            fos.write(bytes, 0, res);
        }
    }

    @Test
    public void test4() throws IOException {
        FileInputStream fis = new FileInputStream("basic.txt");
        FileOutputStream fos = new FileOutputStream("basic4.txt");

        FileChannel sourceFc = fis.getChannel();
        FileChannel destFc = fos.getChannel();

        destFc.transferFrom(sourceFc, 0, sourceFc.size());
        // 关闭
        fis.close();
        fos.close();
    }
}
