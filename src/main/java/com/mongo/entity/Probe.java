package com.mongo.entity;

/**
 * @Classname Probe
 * @Description TODO
 * @Date 8/14/19 10:37 AM
 * @Created by rnd
 */
public class Probe {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    private String name;

    public Probe(String name, String temp, String hum, String unit) {
        this.name = name;
        this.temp = temp;
        this.hum = hum;
        this.unit = unit;
    }

    private String temp;

    private String hum;

    private String unit;
}
