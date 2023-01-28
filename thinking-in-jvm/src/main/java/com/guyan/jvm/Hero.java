package com.guyan.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: GuYan
 * @Time: 2023/1/11 22:15
 * @Description: TODO
 **/
public class Hero {
    private boolean flag;
    private int i;
    private String str;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        Hero a = new Hero();
        System.out.println("new A:" + ClassLayout.parseInstance(a).toPrintable());
        a.setFlag(true);
        a.setI(1);
        a.setStr("ABC");
        System.out.println("赋值 A:" + ClassLayout.parseInstance(a).toPrintable());

        Object[] b = new Object[5];
        b[0] = a;
        b[1] = a;
        System.out.println("数组  b:" + ClassLayout.parseInstance(b).toPrintable());
    }
}
