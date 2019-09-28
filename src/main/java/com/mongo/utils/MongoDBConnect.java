package com.mongo.utils;

import com.mongo.entity.Device;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.data.mongodb.MongoCollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Classname MongoDBConnect
 * Description TODO
 * Date 8/14/19 2:37 PM
 * Created by rnd
 */
public class MongoDBConnect {

    private static String HOST = "127.0.0.1";

    private static int PORT = 27017;

    public static void connMongo(){
        try {
            System.out.println("MongoDBConnect to database begin");
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            //ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress(HOST, PORT);
            List<ServerAddress> address = new ArrayList<>();
            address.add(serverAddress);

            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            //MongoCredential credential = MongoCredential.createScramSha1Credential("admin", "admin", "123456".toCharArray());
            //List<MongoCredential> credentials = new ArrayList<>();
            //credentials.add(credential);

            //通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(address);
            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mongodb");

            //DBCollection con = mongoDatabase.getCollection("device_tb");

           // MongoCollection<Document> collection = mongoDatabase.;





        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }




}
