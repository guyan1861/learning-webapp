package com.guyan.jvm.object;

/**
 * @Author: GuYan
 * @Time: 2023/4/2 16:27
 * @Description: TODO
 **/
public class Picture {
    private byte[] pixels;

    public Picture(int length) {
        this.pixels = new byte[length];
    }
}
