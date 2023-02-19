package com.guyan.rpc.consumer.stub;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: GuYan
 * @Time: 2023/2/17 21:39
 * @Description: TODO
 **/
public class ResultHandler extends ChannelInboundHandlerAdapter {

    /**
     * 服务端返回结果
     */
    private Object response;

    public Object getResponse() {
        return response;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        response = msg;
        ctx.close();
    }
}
