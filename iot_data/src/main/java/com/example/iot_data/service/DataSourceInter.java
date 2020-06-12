package com.example.iot_data.service;


import com.example.iot_data.po.deviceDataList;


public interface DataSourceInter {
    int addDeviceData(deviceDataList data);

    void deleteDeviceData(String name);

    int addExternalData(String path);


}
