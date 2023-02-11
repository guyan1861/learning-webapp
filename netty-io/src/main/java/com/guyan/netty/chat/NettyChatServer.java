package com.guyan.netty.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Author: GuYan
 * @Time: 2023/2/9 22:04
 * @Description: TODO
 **/
public class NettyChatServer {

    private int port;

    public NettyChatServer(int port) {
        this.port = port;
    }

    public void run() throws InterruptedException {
        // 接收客户端请求
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(2);
        // 处理 IO 操作
        NioEventLoopGroup workGroup = new NioEventLoopGroup(3);
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new StringEncoder())
                                    .addLast(new StringDecoder())
                                    .addLast(new NettyChatServerHandler());
                        }
                    });
            System.out.println("网络真人聊天室 Server 启动......");
            ChannelFuture cf = b.bind(port).sync();
            cf.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
            System.out.println("网络真人聊天室 Server 关闭......");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyChatServer(9999).run();
    }
}
