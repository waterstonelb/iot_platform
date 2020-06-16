package com.example.iot_manager.client;

import com.example.iot_manager.vo.SimpleDeviceVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("iot-driver")
public interface DriverServiceClient {

  @PostMapping("/addDevice")
  String addDevice(SimpleDeviceVO simpleDeviceVO);

  @GetMapping("/activateDevice/{deviceId}")
  String notifyOnline(@PathVariable int deviceId);

  @GetMapping("/disableDevice/{deviceId}")
  String notifyDownlinfe(@PathVariable int deviceId);

}
