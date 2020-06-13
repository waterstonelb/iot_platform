package com.example.iot_driver.client;

import com.example.iot_driver.FeignVO.ResponseVO;
import com.example.iot_driver.FeignVO.StatusVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("iot-manager")
public interface IotManagerFeignClient {

    @PostMapping("/device/updateonline")
    ResponseVO<String> updateOnline(@RequestBody StatusVO statusVO);

}
