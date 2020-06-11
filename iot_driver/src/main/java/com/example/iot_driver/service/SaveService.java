package com.example.iot_driver.service;

import com.example.iot_driver.data.SaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveService {

    @Autowired
    private SaveMapper saveMapper;

    public void saveMessage(String topic, String message){
        System.out.println("保存数据到mysql");
       saveMapper.saveMessage(topic.split("/")[0], topic.split("/")[1], message);
    }
}
