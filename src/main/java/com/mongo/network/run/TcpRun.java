package com.mongo.network.run;

import com.mongo.network.model.DataManager;
import com.mongo.network.net.INet;

/**
 * Classname TcpRun
 * Description TODO
 * Date 8/14/19 10:15 AM
 * Created by rnd
 */
public class TcpRun {

    private NetSelect netSelect;

    private DataManager data;

    public void run(){

        data = new DataManager();
        netSelect = new NetSelect(data);

        INet n = netSelect.getSelectedItem();

        assert n != null;
        if(n.start("192.168.0.25",8999)){
            if(n.isServer()){
                System.out.println("服务已经启动成功!");
            }
        }
    }
}
