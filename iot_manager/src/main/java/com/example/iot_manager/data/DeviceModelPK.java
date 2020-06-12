package com.example.iot_manager.data;

import javax.persistence.Id;
import java.io.Serializable;

public class DeviceModelPK implements Serializable {
    @Id
    private int deviceId;
    @Id
    private int modelId;
}
