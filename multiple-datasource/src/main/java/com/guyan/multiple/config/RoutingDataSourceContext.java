package com.guyan.multiple.config;

/**
 * @Author: GuYan
 * @Time: 2022/9/13 21:23
 * @Description: TODO
 **/
public class RoutingDataSourceContext {
    static final ThreadLocal<String> threadLocal = new ThreadLocal();

    public RoutingDataSourceContext(String key) {
        threadLocal.set(key);
    }

    public static String getDatasourceRoutingKey() {
        String key = threadLocal.get();
        return key == null ? "mater" : key;
    }

    public void close() {
        threadLocal.remove();
    }
}
