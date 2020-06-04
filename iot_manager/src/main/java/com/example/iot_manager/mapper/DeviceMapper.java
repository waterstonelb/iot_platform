package com.example.iot_manager.mapper;

import com.example.iot_manager.data.Device;
import java.util.List;

public interface DeviceMapper {
  int addDevice(Device device);
  int updateDevice(Device device);
  Device findDeviceById(Integer id);
  int deleteDeviceById(Integer id);
  List<Device> findAllDevice();
}
