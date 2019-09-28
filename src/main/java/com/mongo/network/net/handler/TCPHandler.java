package com.mongo.network.net.handler;


import com.mongo.network.listener.MessageReceivedListener;
import com.mongo.network.model.DataManager;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class TCPHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private DataManager data;
    private MessageReceivedListener listener;

    public TCPHandler(DataManager data, MessageReceivedListener listener) {
        this.data = data;
        this.listener = listener;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //data.addConnect(ctx.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIP = insocket.getAddress().getHostAddress();
        //String clientPort = String.valueOf(insocket.getPort());
        //String allAddress = clientIP+":"+clientPort;
        byte[] data = new byte[msg.readableBytes()];
        msg.readBytes(data);
        listener.messageReceived(clientIP,data);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (cause instanceof IOException) {
           // data.removeConnect(ctx.channel());
            return;
        }
        //JOptionPane.showMessageDialog(data.getComponent(), "服务器异常", "服务器异常", JOptionPane.OK_OPTION);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
       // data.removeConnect(ctx.channel());
    }
}
