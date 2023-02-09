package com.guyan.netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author: GuYan
 * @Time: 2023/2/9 20:22
 * @Description: TODO
 **/
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup eventLoop = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoop).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new NettyClientHandler());
            }
        });
        System.out.println(".....客户端准备就绪 msg 发射");
        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9999);
        channelFuture.channel().closeFuture().sync();
    }
}
