package com.example.iot_driver.client;

import com.example.iot_driver.vo.ResponseEntity;
import com.example.iot_driver.vo.TopicPO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("iot-rule")
public interface IotRuleFeignClient {

    @PostMapping("/rules/data")
    ResponseEntity<TopicPO> receiveData(@RequestBody TopicPO topicPO);

    // 测试用接口
    @PostMapping("/rules/dataTest")
    ResponseEntity<TopicPO> receiveDataTest(@RequestBody TopicPO topicPO);

    @GetMapping("/rules/hello")
    String test();
}
