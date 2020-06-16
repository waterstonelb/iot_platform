package com.example.iot_manager.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "device_model")
@IdClass(DeviceModelPK.class)
public class DeviceModelDo {
    @Id
    private int deviceId;
    @Id
    private int modelId;
}
