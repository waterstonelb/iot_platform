package com.example.iot_data.service;

import com.example.iot_data.po.deviceData;

import java.util.List;

public interface DataAssetInter {
    List<deviceData> getData(String name);
    List<deviceData> getDevice();
}
