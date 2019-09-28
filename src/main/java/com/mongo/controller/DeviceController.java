package com.mongo.controller;

import com.mongo.base.BaseResp;
import com.mongo.entity.AllData;
import com.mongodb.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Classname DeviceController
 * Description TODO
 * Date 8/14/19 3:20 PM
 * Created by rnd
 */

@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"},value = {"/device"})
public class DeviceController {

    private static final String MONGO_HOST = "localhost";
    private static final Integer MONGO_PORT = 27017;


    @RequestMapping(value = {"/getAllDevice"}, method = {RequestMethod.GET})
    @ResponseBody
    public BaseResp<AllData> getAllDevice(@RequestParam(value = "ip") String ip){
        BaseResp resp = new BaseResp();
        try{

            //String ip = req.getIp();

            MongoClient mongoClient = new MongoClient(MONGO_HOST,MONGO_PORT);
            DB db = mongoClient.getDB("mongodb");

            DBCollection con = db.getCollection("device_tb");


            BasicDBObject query = new BasicDBObject();

            query.put("ip", ip);

            List<DBObject> result=con.find(query).limit(100).toArray();

            if(result.size()==0){
                resp.setCode("100");
                resp.setMessage("获取失败");
                return resp;
            }
            resp.setCode("200");
            resp.setMessage("获取成功");
            resp.setData(result);
            return resp;
        }catch (Exception e){
           e.printStackTrace();
            resp.setCode("500");
            resp.setMessage("服务器错误");
            return resp;
        }
    }


    @RequestMapping(value = {"/getDevice"}, method = {RequestMethod.GET})
    @ResponseBody
    public BaseResp<AllData> getDevice(@RequestParam(value = "ip") String ip){

        BaseResp resp = new BaseResp();
        try{
            //String ip = "192.168.0.25";
            MongoClient mongoClient = new MongoClient(MONGO_HOST,MONGO_PORT);
            DB db = mongoClient.getDB("mongodb");

            DBCollection con = db.getCollection("device_tb");


            BasicDBObject query = new BasicDBObject();

            query.put("ip", ip);

            DBCursor cursor = con.find(query).sort(new BasicDBObject("_id", -1)).limit(1);

            DBObject result=cursor.next();
            //反转
            //User u=gson.fromJson(obj.toString(), User.class);
            //System.out.println(u.name);
            if(result==null){
                resp.setCode("100");
                resp.setMessage("获取失败");
                return resp;
            }
            resp.setCode("200");
            resp.setMessage("获取成功");
            resp.setData(result);
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode("500");
            resp.setMessage("服务器错误");
            return resp;
        }
    }
}
