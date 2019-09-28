package com.mongo.network.run;

import com.mongo.network.listener.MessageReceivedListener;
import com.mongo.network.model.DataManager;
import com.mongo.network.net.INet;
import com.mongo.network.net.NetTCPServer;

import javax.swing.*;

/**
 * @Classname NetSelect
 * @Description TODO
 * @Date 8/14/19 10:18 AM
 * @Created by rnd
 */

@SuppressWarnings("serial")
public class NetSelect extends JComboBox<INet>{

    public NetSelect(DataManager data){
        //数据监听器，在收到数据之后，添加到数据中心
        MessageReceivedListener messageReceived = data::addMessage;

        // 网络类型集合
        addItem(new NetTCPServer(data, messageReceived));
    }

    @Override
    public INet getSelectedItem() {
        return (INet) super.getSelectedItem();
    }

}
