package com.guyan.jvm.layout;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: GuYan
 * @Time: 2023/4/6 23:35
 * @Description: TODO
 **/
public class ObjLock01 {
    public static void main(String[] args) {
        /*
            1.32位机器 对象头占 4 + 4 = 8
            2.64位机器 对象头占 8 + 4 + 4 = 16
         */
        Object o = new Object();
        System.out.println("new Object:" + ClassLayout.parseInstance(o).toPrintable());
    }
}
