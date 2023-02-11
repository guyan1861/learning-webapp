package com.guyan.netty.encode;

import com.guyan.netty.encode.po.BookMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: GuYan
 * @Time: 2023/2/11 11:18
 * @Description: TODO
 **/
public class NettyClientEncodeDecoderHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        BookMessage.Book.Builder book = BookMessage.Book.newBuilder().setId(1).setName("天王盖地虎");
        ctx.writeAndFlush(book);
    }
}
