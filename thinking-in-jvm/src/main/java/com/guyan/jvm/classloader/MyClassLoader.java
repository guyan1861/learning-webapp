package com.guyan.jvm.classloader;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @Author: GuYan
 * @Time: 2022/7/16 21:49
 * @Description: TODO
 **/
public class MyClassLoader extends ClassLoader {
    protected MyClassLoader() {
        super();
    }

    byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] bytes = new byte[0];
        try {
            bytes = loadFromFile("/Users/guyan/workspace/github/guyan/learning-webapp/thinking-in-jvm/src/main/java/com/guyan/jvm/classloader/Hello.xlass");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

    public static void main(String[] args) {
        try {
            Object hello = new MyClassLoader().findClass("Hello").newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取文件并转为字节流
     */

    public byte[] loadFromFile(String pathname) throws IOException {
        FileInputStream is = new FileInputStream(pathname);
        byte buffer[];
        ByteOutputStream byteOutputStream = new ByteOutputStream();
        int value;
        while ((value = is.read()) != -1) {
            byteOutputStream.write(255 - value);
        }
        buffer = byteOutputStream.toByteArray();
        return buffer;
    }
}
