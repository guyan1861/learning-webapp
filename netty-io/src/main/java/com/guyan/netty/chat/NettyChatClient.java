package com.guyan.netty.chat;

import com.guyan.netty.demo.NettyClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @Author: GuYan
 * @Time: 2023/2/9 22:31
 * @Description: TODO
 **/
public class NettyChatClient {
    private final String host;
    private final int port;

    public NettyChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * netty 客户端发送数据和监听服务端数据
     */
    public void run() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ChannelPipeline pipeline = socketChannel.pipeline();
                    // 添加一个解码器、编码器、业务处理类
                    pipeline.addLast(new StringEncoder()).addLast(new StringDecoder()).addLast(new NettyChatClientHandler());
                }
            });

            ChannelFuture cf = bootstrap.connect(host, port).sync();
            Channel channel = cf.channel();
            System.out.println("-------" + channel.remoteAddress().toString().substring(1) + "------");

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String msg = scanner.nextLine();
                channel.writeAndFlush(msg + "\n");
                if(msg.equals("bye")){
                    break;
                }
            }
            channel.closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new NettyChatClient("127.0.0.1", 9999).run();
    }
}
