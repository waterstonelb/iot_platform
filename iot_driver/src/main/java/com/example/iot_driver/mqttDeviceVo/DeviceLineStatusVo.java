package com.example.iot_driver.mqttDeviceVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 设备上下线vo
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceLineStatusVo {

    private Integer deviceId;
    // 状态 0下线 1上线
    private Integer status;
}
