package com.guyan.netty.http;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpContentDecompressor;

/**
 * @Author: GuYan
 * @Time: 2023/2/13 22:08
 * @Description: TODO
 **/
public class NettyHttpClient {
    public static void main(String[] args) {
        // 初始化线程组，发请求
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class)
                 .option(ChannelOption.SO_BACKLOG, 128)
                 .option(ChannelOption.SO_KEEPALIVE, true)
                 .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new HttpContentDecompressor());
                        pipeline.addLast(new HttpContentCompressor());
                        pipeline.addLast(new NettyHttpClientHandler());
                    }
        });
    }
}
