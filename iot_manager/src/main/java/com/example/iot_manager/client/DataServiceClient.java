package com.example.iot_manager.client;

import com.example.iot_manager.vo.DataTransList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("iot-data")
public interface DataServiceClient {

  @PostMapping("/addDeviceData")
  int addDevicedata(@RequestBody DataTransList data);

}
