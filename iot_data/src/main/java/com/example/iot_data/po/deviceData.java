package com.example.iot_data.po;

public class deviceData {
    private int id;
    private String name;
    private double temperature;
    private double press;
    private String time;
    private String ip;

    public String getName(){return name;}

    public void setName(String name){
        this.name=name;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getTime() {
        return time;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPress() {
        return press;
    }

    public void setPress(double press) {
        this.press = press;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
