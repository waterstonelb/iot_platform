package com.example.iot_data.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @GetMapping("/test")
    public String test(){
        return "hello data";
    }
}
