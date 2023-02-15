package com.guyan.rpc.producer.stub;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @Author: GuYan
 * @Time: 2023/2/15 21:17
 * @Description: TODO
 **/
public class InvokeHandler extends ChannelInboundHandlerAdapter {

    private String getClassNameImpl(ClassInfo classInfo) throws ClassNotFoundException {
        // 服务方接口和实现类所在的路径
        String interfacePath = "com.guyan.rpc.producer";
        int lastDot = classInfo.getClassName().lastIndexOf(".");
        // 接口名称 其实也是类名称
        String interfaceName = classInfo.getClassName().substring(lastDot);
        // 接口字节码对象
        Class superClass = Class.forName(interfacePath + interfaceName);

        Reflections reflections = new Reflections(interfacePath);

        Set<Class> implClassSet = reflections.getSubTypesOf(superClass);

        if(implClassSet.size() == 0) {
            System.out.println("未找到实现类");
            return null;
        } else if(implClassSet.size() > 1) {
            System.out.println("找到多个实现类，未明确使用哪一个");
            return null;
        } else {
            Class[] classes = implClassSet.toArray(new Class[0]);
            return classes[0].getName();
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ClassInfo classInfo = (ClassInfo) msg;
        Object instance = Class.forName(getClassNameImpl(classInfo)).newInstance();
        Method method = instance.getClass().getMethod(classInfo.getMethodName(), classInfo.getTypes());
        // 通过反射调用实现类的方法
        Object result = method.invoke(instance, classInfo.getObjects());
        ctx.writeAndFlush(result);
    }
}
