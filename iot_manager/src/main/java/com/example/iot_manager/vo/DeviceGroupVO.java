package com.example.iot_manager.vo;

import com.example.iot_manager.data.DeviceDo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceGroupVO {
    private int deviceId;
    private String name;
    private Date updateTime;

}
