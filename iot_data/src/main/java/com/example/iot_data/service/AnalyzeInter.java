package com.example.iot_data.service;

import com.example.iot_data.po.deviceData;

import java.util.List;

public interface AnalyzeInter {
    List<deviceData> getDataByTime(String name,String time1,String time2);
    List<deviceData> getDeviceData(String name);
    List<deviceData> getDeviceDataByCondition(String name,double temperature1,double temperature2,double press1,double press2,String time1,String time2,String attr,int p);
}
