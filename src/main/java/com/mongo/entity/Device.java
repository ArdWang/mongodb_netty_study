package com.mongo.entity;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Classname Device
 * Description TODO
 * Date 8/14/19 10:36 AM
 * Created by rnd
 */
public class Device {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Probe> getData() {
        return data;
    }

    public void setData(List<Probe> data) {
        this.data = data;
    }

    @Id
    private Long id;


    public Device(Long id, String code, String message, List<Probe> data) {
        this.id = id;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    private String code;

    private String message;

    private List<Probe> data;

}
