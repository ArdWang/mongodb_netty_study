package com.mongo.entity;

/**
 * Classname AllData
 * Description TODO
 * Date 8/14/19 3:22 PM
 * Created by rnd
 */
public class AllData {

    private Long _id;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    private Device device;

    private String ip;

}
