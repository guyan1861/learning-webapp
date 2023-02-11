package com.guyan.netty.encode;

import com.guyan.netty.encode.po.BookMessage;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

/**
 * @Author: GuYan
 * @Time: 2023/2/11 11:21
 * @Description: TODO
 **/
public class NettyServerEncodeDecoder {
    public static void main(String[] args) throws InterruptedException {
        // 处理网络事件，接收请求
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        // 进行网络通讯读写
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boosGroup, workGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline pipeline = socketChannel.pipeline();
                pipeline.addLast("decoder", new ProtobufDecoder(BookMessage.Book.getDefaultInstance()));
                pipeline.addLast(new NettyServerEncodeDecoderHandler());
            }
        });
        ChannelFuture channelFuture = bootstrap.bind(9999);
        System.out.println("server starting .........");
        channelFuture.channel().closeFuture().sync();
        boosGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }
}
