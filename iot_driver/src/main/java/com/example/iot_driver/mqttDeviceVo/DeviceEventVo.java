package com.example.iot_driver.mqttDeviceVo;

import lombok.*;

import java.sql.Timestamp;

/**
 * 设备事件上报vo
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceEventVo {

    private Integer deviceId;

    private String eventName;

    private Timestamp timestamp;

    private String eventDescribe;
}
