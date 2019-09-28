package com.mongo.utils;

import org.json.JSONObject;
import org.thethingsnetwork.data.common.Connection;
import org.thethingsnetwork.data.common.messages.ActivationMessage;
import org.thethingsnetwork.data.mqtt.Client;

import java.util.function.BiConsumer;

/**
 * Classname TTNStart
 * Description TODO
 * Date 8/21/19 1:28 PM
 * Created by rnd
 */
public class TTNStart {

    private final static String region = "eu";
    private final static String appId = "rillorawanserver";
    private final static String accessKey = "ttn-account-v2.YcA9PF5xVDQkKYyHCgHwzM6lRnJa6r1VUqEQVOp0j4Q";

    public static void start(){
        try {
            Client client = new Client(region, appId, accessKey);
            client.start();

            client.onError((Throwable _error) -> System.err.println("error: " + _error.getMessage()));

            client.onConnected((Connection _client) -> System.out.println("connected !"));

            client.onActivation((s, activationMessage) ->
                System.out.println("Message: " + s + " " + activationMessage));
            //client.onMessage((String devId, Object data) -> System.out.println("Message: " + devId + " " + data));


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
