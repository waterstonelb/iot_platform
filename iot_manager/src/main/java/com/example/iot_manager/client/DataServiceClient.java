package com.example.iot_manager.client;

import com.example.iot_manager.vo.DataTransVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("IOT-DATA")
public interface DataServiceClient {

  @PostMapping("/addDeviceData")
  int addDevicedata(@RequestBody DataTransVO dataTransVO);

}
