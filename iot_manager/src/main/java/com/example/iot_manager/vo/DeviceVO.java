package com.example.iot_manager.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceVO {
    private int groupId;
    private String deviceName;
    private String protocol;
    private String ipAddress;
    private String deviceDescription;
}
