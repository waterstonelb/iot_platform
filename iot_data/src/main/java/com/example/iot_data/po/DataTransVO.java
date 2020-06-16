package com.example.iot_data.po;

import java.util.Date;
import java.util.List;
import lombok.ToString;

public class DataTransVO {
    private int id;
    private List<SimpleModelVO> modelVOs;
    private String name;
    private Date time;
    private String ip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<SimpleModelVO> getModelVOs() {
        return modelVOs;
    }

    public void setModelVOs(List<SimpleModelVO> modelVOs) {
        this.modelVOs = modelVOs;
    }
}
