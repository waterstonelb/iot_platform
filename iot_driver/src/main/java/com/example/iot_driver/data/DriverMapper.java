package com.example.iot_driver.data;

import com.example.iot_driver.vo.DeviceConnectInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@Mapper
public interface DriverMapper {

    int addConnect(DeviceConnectInfo deviceConnectInfo);

    int modifyConnectInfo(DeviceConnectInfo deviceConnectInfo);

    DeviceConnectInfo getConnectInfo(String deviceId);

    HashMap getStatusAndQos(String deviceId);

    /** 获得设备qos*/
    int getQosById(String deviceId);

    /** 更新设备在线状态*/
    int updateStatus(@Param("status") int status, @Param("deviceId") String deviceId);

    int getStatus(String deviceId);

    List<String> getAllDeviceId();
}
