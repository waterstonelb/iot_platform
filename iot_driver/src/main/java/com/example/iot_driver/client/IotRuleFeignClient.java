package com.example.iot_driver.client;

import com.example.iot_driver.FeignVO.TopicPO;
import com.example.iot_driver.FeignVO.TopicVO;
import com.example.iot_driver.vo.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("iot-rule")
public interface IotRuleFeignClient {

    @PostMapping("/rules/data")
    ResponseEntity<List<TopicVO>> receiveData(@RequestBody TopicPO topicPO);

    // 测试用接口
    @PostMapping("/rules/dataTest")
    ResponseEntity<TopicVO> receiveDataTest(@RequestBody TopicPO topicPO);

    @GetMapping("/rules/hello")
    String test();
}
