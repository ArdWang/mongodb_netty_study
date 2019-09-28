package com.mongo.network.model;


import com.mongodb.*;


public class DataManager {
    private DB db;
    private static final String MONGO_HOST = "localhost";
    private static final Integer MONGO_PORT = 27017;


    public DataManager() {
        MongoClient mongoClient = new MongoClient(MONGO_HOST,MONGO_PORT);
        db = mongoClient.getDB("mongodb");
    }


    public void addMessage(String ip,byte[] bytes) {
        Data data = new Data(bytes);
        //转为字符串
        String result = data.toString();
        DBObject user_json = (DBObject) com.mongodb.util.JSON.parse(result);
        user_json.put("_id",System.currentTimeMillis());
        user_json.put("ip",ip);
        DBCollection con = db.getCollection("device_tb");
        con.insert(user_json);
    }

}
