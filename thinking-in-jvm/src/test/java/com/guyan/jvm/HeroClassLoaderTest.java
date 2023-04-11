package com.guyan.jvm;

import java.lang.reflect.Method;

/**
 * @Author: GuYan
 * @Time: 2023/4/2 15:44
 * @Description: TODO
 **/
public class HeroClassLoaderTest {
    public static void main(String[] args) throws Exception {
        HeroClassLoader loader = new HeroClassLoader("/Users/guyan/workspace/github/learning-webapp/thinking-in-jvm/src/main/java");
        Class<?> c = loader.findClass("com.guyan.jvm.Test");
        if(c != null) {
            Object obj = c.newInstance();
            Method method = c.getMethod("say", null);
            method.invoke(obj, null);
            System.out.println(c.getClassLoader().toString());
        }
    }
}
