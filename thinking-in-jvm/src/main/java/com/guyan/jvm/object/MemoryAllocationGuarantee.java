package com.guyan.jvm.object;

/**
 * @Author: GuYan
 * @Time: 2023/4/6 23:52
 * @Description: TODO
 **/
public class MemoryAllocationGuarantee {
    /*
        空间内存担保机制：
            新分配对象 Eden 区装不下，开启 minorGC
            幸存的对象转移到 survivor ，survivor也装不下
            直接把这部分对象转移到老年代

        目的：尽快让长期存活的对象进入老年代
     */
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        memoryAllocation();
    }

    public static void memoryAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[1 * _1MB]; // 1M
        allocation2 = new byte[1 * _1MB]; // 1M
        allocation3 = new byte[1 * _1MB]; // 1M
        allocation4 = new byte[5 * _1MB]; // 5M
        System.out.println("完毕");
    }
}
