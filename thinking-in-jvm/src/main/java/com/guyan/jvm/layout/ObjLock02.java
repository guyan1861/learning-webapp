package com.guyan.jvm.layout;

import com.guyan.jvm.Hero;
import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: GuYan
 * @Time: 2023/4/6 23:38
 * @Description: TODO
 **/
public class ObjLock02 {
    public static void main(String[] args) {
        /**
         * 对象对齐补充，并不是最后再不起，而是中间有不是8的倍数的，就会补齐
         */
        Hero a = new Hero();
        System.out.println("new A:" + ClassLayout.parseInstance(a).toPrintable());
        a.setFlag(true);
        a.setI(1);
        a.setStr("ABC");
        System.out.println("赋值 A:" + ClassLayout.parseInstance(a).toPrintable());
    }
}
