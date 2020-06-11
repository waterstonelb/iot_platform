package com.example.iot_data.service;

public interface DataSourceInter {
    int addDeviceData(String name);

    void deleteDeviceData(String name);

    int addExternalData(String path);


}
