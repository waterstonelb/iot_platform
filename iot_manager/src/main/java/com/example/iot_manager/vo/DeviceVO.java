package com.example.iot_manager.vo;

import com.example.iot_manager.data.DeviceDo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceVO {
    private int groupId;
    private List<Integer> modelIds;
    private String deviceName;
    private String protocol;
    private String ipAddress;
    private String deviceDescription;

}
