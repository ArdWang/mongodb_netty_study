package com.mongo.network.listener;

/**
 * Classname MessageReceivedListener
 * Description 信息接收监听
 * Date 8/13/19 10:12 AM
 * Created by rnd
 */
public interface MessageReceivedListener {

    void messageReceived(String ip, byte[] data);
}
