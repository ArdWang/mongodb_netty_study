package com.mongo.network.net.handler;


import com.mongo.network.listener.MessageReceivedListener;
import com.mongo.network.model.DataManager;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import java.net.InetSocketAddress;

//import io.netty.channel.ChannelHandler.Sharable;

public class UDPHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    private DataManager data;
    private MessageReceivedListener listener;

    public UDPHandler(DataManager data, MessageReceivedListener listener) {
        this.data = data;
        this.listener = listener;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIP = insocket.getAddress().getHostAddress();
        String clientPort = String.valueOf(insocket.getPort());
        String allAddress = clientIP+":"+clientPort;
        //data.addConnect(msg.sender());
        ByteBuf buf = msg.copy().content();
        byte[] data = new byte[buf.readableBytes()];
        buf.readBytes(data);
        listener.messageReceived(allAddress,data);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //JOptionPane.showMessageDialog(data.getComponent(), "服务器异常", "服务器异常", JOptionPane.OK_OPTION);
    }
}
