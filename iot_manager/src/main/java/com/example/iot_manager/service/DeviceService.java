package com.example.iot_manager.service;


import com.example.iot_manager.data.DeviceDo;
import com.example.iot_manager.vo.DeviceVO;
import com.example.iot_manager.vo.ResponseVO;

import java.util.List;

public interface DeviceService {

    ResponseVO<String> addDevice(DeviceVO deviceVO);

    ResponseVO<String> deleteDevice(int deviceId);

    ResponseVO<String> updateDevice(DeviceDo deviceDo);

    ResponseVO<String> updateStatus(int status, int deviceId);

    ResponseVO<String> updateOnline(int isOnline, int deviceId);

    ResponseVO<List<DeviceDo>> getAllDevice(int page, int size);

    ResponseVO<DeviceDo> getDeviceById(int deviceId);

    ResponseVO<List<DeviceDo>> getDeviceByNameLike(String deviceName, int page, int size);

}
