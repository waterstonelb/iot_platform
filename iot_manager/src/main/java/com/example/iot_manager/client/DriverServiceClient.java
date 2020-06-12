package com.example.iot_manager.client;

import com.example.iot_manager.data.DeviceDo;
import com.example.iot_manager.vo.SimpleDeviceVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("IOT-DRIVER")
public interface DriverServiceClient {

  @PostMapping("/add")
  String addDevice(SimpleDeviceVO simpleDeviceVO);
}
