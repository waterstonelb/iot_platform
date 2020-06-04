package com.example.iot_manager.controller;

import com.example.iot_manager.service.RedisTestServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    @Autowired
    RedisTestServive redisTestServive;

    @GetMapping("/test")
    public String test(){
        return redisTestServive.set();
    }
}
