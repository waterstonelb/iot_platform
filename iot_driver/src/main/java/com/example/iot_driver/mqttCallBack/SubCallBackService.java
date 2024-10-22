package com.example.iot_driver.mqttCallBack;

import com.example.iot_driver.service.DataForwarding;
import com.example.iot_driver.service.ICoreServiceInner;
import com.example.iot_driver.service.IotManagerFeignImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCallBackService {

    @Autowired
    private ICoreServiceInner coreServiceInner;


    @Autowired
    private DataForwarding dataForwarding;

    @Autowired
    private IotManagerFeignImpl iotManagerFeign;

    /** 设备消息处理*/
    public void messageHandle(String topic, String message){
        boolean isValid = coreServiceInner.isValidTopic(topic);
        if (isValid){
            iotManagerFeign.receiveData(topic,message);
            dataForwarding.receiveData(topic,message);
        }
    }

//    /** 掉线重连重新订阅*/
//    public void initSub() throws MqttException {
//        coreServiceInner.initSub();
//    }
}
