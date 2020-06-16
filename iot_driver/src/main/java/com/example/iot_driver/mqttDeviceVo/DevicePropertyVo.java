package com.example.iot_driver.mqttDeviceVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

/**
 * 请求设备属性与设备属性上报vo
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DevicePropertyVo {

    private Integer deviceId;

    private UUID messageId;

    private boolean success;

    private Map<String,Object> properties;

    private Timestamp timestamp;
}
