package com.guyan.jvm.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: GuYan
 * @Time: 2023/4/2 16:26
 * @Description: -Xmx600m -Xms600m -XX:+PrintGCDetails
 **/
public class HeapInstance {
    public static void main(String[] args) {
        List<Picture> list = new ArrayList<>();
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Picture(new Random().nextInt(1024 * 1024)));
        }
    }
}
