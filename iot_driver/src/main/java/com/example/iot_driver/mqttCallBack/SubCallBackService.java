package com.example.iot_driver.mqttCallBack;

import com.example.iot_driver.service.ICoreServiceInner;
import com.example.iot_driver.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCallBackService {

    @Autowired
    private ICoreServiceInner coreServiceInner;

    @Autowired
    private SaveService saveService;

    /** 设备消息处理*/
    public void messageHandle(String topic, String message){
        System.out.println(topic);
        System.out.println(message);
        boolean isValid = coreServiceInner.isValidTopic(topic);
        if (isValid){
            saveService.saveMessage(topic, message);
        }
    }

//    /** 掉线重连重新订阅*/
//    public void initSub() throws MqttException {
//        coreServiceInner.initSub();
//    }
}
