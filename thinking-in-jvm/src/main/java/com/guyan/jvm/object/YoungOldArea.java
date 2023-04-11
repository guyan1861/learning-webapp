package com.guyan.jvm.object;

/**
 * @Author: GuYan
 * @Time: 2023/4/2 16:09
 * @Description: 测试大对象直接进入老年代
 *  -Xmx60m -Xms60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails  -XX:PretenureSizeThreshold
 *  Young 20M Eden:16M S1:2M S2:2M Old 40M
 **/
public class YoungOldArea {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024*1024*20]; //20M
    }
}
