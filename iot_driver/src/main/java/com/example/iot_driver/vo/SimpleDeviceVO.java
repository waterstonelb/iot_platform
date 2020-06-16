package com.example.iot_driver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class SimpleDeviceVO {
    private int deviceId;

    private int groupId;

    private String deviceName;

    private int deviceStatus;

    private int isOnline;

    private String protocol;

    private String ipAddress;



}
