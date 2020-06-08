package com.example.iot_driver.service;

import com.example.iot_driver.data.DriverMapper;
import com.example.iot_driver.vo.DeviceConnectInfo;
import com.example.iot_driver.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class DriverService {

    @Autowired
    private ICoreServiceOuter coreServiceOuter;

    @Autowired
    private DriverMapper driverMapper;

    public ResponseVO addConnect(DeviceConnectInfo deviceConnectInfo){
        if (driverMapper.addConnect(deviceConnectInfo) > 0){
            return ResponseVO.buildSuccess("连接信息创建成功");
        }else {
            return ResponseVO.buildFailure("连接信息创建失败");
        }
    }

    public ResponseVO modifyConnectInfo(DeviceConnectInfo deviceConnectInfo){
        int status = driverMapper.getStatus(deviceConnectInfo.getDeviceId());
        if (status == 1){
            return ResponseVO.buildFailure("设备必须离线才能修改");
        }else {
            if (driverMapper.modifyConnectInfo(deviceConnectInfo) > 0){
                return ResponseVO.buildSuccess("更新成功");
            }else {
                return ResponseVO.buildFailure("更新失败");
            }
        }
    }

    public ResponseVO getConnectInfo(String deviceId){
        return ResponseVO.buildSuccess(driverMapper.getConnectInfo(deviceId));
    }

    public ResponseVO deviceOnline(String deviceId){
        String[] topic = new String[] {deviceId+ "/+"};
        int qos = driverMapper.getQosById(deviceId);
        boolean b = coreServiceOuter.addSub(topic, qos);
        if (b){
            // 1表示设备在线
            int n = driverMapper.updateStatus(1, deviceId);
            if (n > 0){
                return ResponseVO.buildSuccess("设备上线成功");
            }else {
                return ResponseVO.buildFailure("设备状态更新失败");
            }
        }else {
            return ResponseVO.buildFailure("订阅设备主题失败");
        }
    }

    public ResponseVO deviceOffline(String deviceId){
        String[] topic = new String[] {deviceId+ "/+"};
        boolean success = coreServiceOuter.removeSub(topic);
        if (success){
            // 0表示设备离线
            int n = driverMapper.updateStatus(0, deviceId);
            if (n > 0){
                return ResponseVO.buildSuccess("设备离线成功");
            }else {
                return ResponseVO.buildFailure("设备状态更新失败");
            }
        }else {
            return ResponseVO.buildFailure("取消订阅设备主题失败");
        }
    }

    public ResponseVO sendMessageToDevice(String deviceId, String message){
        HashMap hashMap = driverMapper.getStatusAndQos(deviceId);
        System.out.println(hashMap.toString());
        // 这里应该判断设备是否离线 离线则应该将数据发往影子设备
        boolean success = coreServiceOuter.addPub(deviceId, (Integer) hashMap.get("qos"), message);
        if (success){
            return ResponseVO.buildSuccess("消息发送成功");
        }else {
            return ResponseVO.buildFailure("消息发送失败");
        }
    }
}
