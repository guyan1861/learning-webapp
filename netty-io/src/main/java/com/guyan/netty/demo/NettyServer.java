package com.guyan.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: GuYan
 * @Time: 2023/2/9 20:22
 * @Description: TODO
 **/
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        // 接收客户端请求
        NioEventLoopGroup bossGroupLoop = new NioEventLoopGroup(2);
        // 处理 IO 操作
        NioEventLoopGroup workGroupLoop = new NioEventLoopGroup(3);

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossGroupLoop, workGroupLoop).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 128).option(ChannelOption.SO_KEEPALIVE, true).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new NettyServerHandler());
            }
        });
        System.out.println("......服务端 启动中 init port:9999 ......");
        ChannelFuture cf = serverBootstrap.bind(9999).sync();
        System.out.println("......服务端 启动成功 ......");

        cf.channel().closeFuture().sync();
        bossGroupLoop.shutdownGracefully();
        workGroupLoop.shutdownGracefully();
    }
}
