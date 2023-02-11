package com.guyan.netty.encode;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

/**
 * @Author: GuYan
 * @Time: 2023/2/11 11:10
 * @Description: TODO
 **/
public class NettyClientEncodeDecoder {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class)
                 .handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline pipeline = socketChannel.pipeline();
                pipeline.addLast("encoder",new ProtobufEncoder());
                pipeline.addLast(new NettyClientEncodeDecoderHandler());
            }
        });
        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9999);
        channelFuture.channel().closeFuture().sync();
    }
}
