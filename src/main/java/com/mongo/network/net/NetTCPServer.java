package com.mongo.network.net;


import com.mongo.network.listener.MessageReceivedListener;
import com.mongo.network.model.DataManager;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import javax.swing.*;
import java.util.List;

public class NetTCPServer extends AbstractNetTcp {

    private ServerBootstrap server;

    public NetTCPServer(DataManager data, MessageReceivedListener listener) {
        super(data, listener, "TCP Server");
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(bossGroup, workGroup);
        server.channel(NioServerSocketChannel.class);
        server.childHandler(initializer);
    }

    public boolean start(String ip, int port) {
        try {
            ChannelFuture f = server.bind(ip, port).sync();
            channel = f.channel();
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, "服务器异常", "服务器异常", JOptionPane.OK_OPTION);
            return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void sendMsg(String text) {
        //List<Object> channels = data.getConnections();
        byte[] bytes = msg2Bytes(text);
        if (bytes != null) {
//            for (Object obj : channels) {
////                if (obj instanceof ChannelOption) {
////                    ChannelOption c = (ChannelOption) obj;
////                    c.getChannel().writeAndFlush(bytes);
////                } else {
////                    System.err.println("TCP 连接列表中有非TCP连接" + obj);
////                }
//            }
        }

    }

    @Override
    public boolean isServer() {
        return true;
    }
}
