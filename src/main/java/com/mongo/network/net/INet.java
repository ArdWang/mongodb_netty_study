package com.mongo.network.net;

public interface INet {
    boolean start(String ip, int port);

    boolean stop();

    void sendMsg(String text);

    boolean isServer();

    boolean canRemoveClient();

    boolean needTarget();
}
