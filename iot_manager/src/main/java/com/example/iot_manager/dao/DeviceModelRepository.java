package com.example.iot_manager.dao;

import com.example.iot_manager.data.DeviceModelDo;
import com.example.iot_manager.data.DeviceModelPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceModelRepository extends JpaRepository<DeviceModelDo, DeviceModelPK> {
    List<DeviceModelDo> findByDeviceId(int deviceId);
}
