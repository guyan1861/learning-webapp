package com.guyan.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GuYan
 * @Time: 2023/2/9 22:12
 * @Description: TODO
 **/
public class NettyChatServerHandler extends SimpleChannelInboundHandler<String> {

    public static List<Channel> channels = new ArrayList<>();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel inChannel = ctx.channel();
        channels.add(inChannel);
        System.out.println("[Server] :" + inChannel.remoteAddress().toString().substring(1) + "上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel inChannel = ctx.channel();
        channels.remove(inChannel);
        System.out.println("[Server] :" + inChannel.remoteAddress().toString().substring(1) + "离线");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        Channel inChannel = channelHandlerContext.channel();
        System.out.println("s = " + s);
        for (Channel channel : channels) {
            if(channel != inChannel) {
                channel.writeAndFlush("[" + inChannel.remoteAddress().toString().substring(1) + "]：" + s + "\n");
            }
        }
    }
}
