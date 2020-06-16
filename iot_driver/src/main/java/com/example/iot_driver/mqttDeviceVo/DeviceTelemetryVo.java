package com.example.iot_driver.mqttDeviceVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * 设备遥测数据上传
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeviceTelemetryVo {

    private Integer deviceId;

    private Map<String,Object> properties;

}
