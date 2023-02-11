package com.guyan.netty.encode;

import com.guyan.netty.encode.po.BookMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: GuYan
 * @Time: 2023/2/11 11:20
 * @Description: TODO
 **/
public class NettyServerEncodeDecoderHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        BookMessage.Book book = (BookMessage.Book) msg;
        System.out.println("client msg:" + book.getName());
    }
}
