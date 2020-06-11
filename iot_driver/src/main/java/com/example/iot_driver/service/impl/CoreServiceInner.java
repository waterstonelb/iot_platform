package com.example.iot_driver.service.impl;

import com.example.iot_driver.service.ICoreServiceInner;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.springframework.stereotype.Service;

@Service
public class CoreServiceInner implements ICoreServiceInner {

    private MqttClient mqttClient;

    @Override
    public boolean initSub(){
        System.out.println("这里做重新订阅（结合实际业务）");
        return false;
    }

    // 这里判断主题是否有效
    @Override
    public boolean isValidTopic(String topic) {
        String[] topicList = topic.split("/");
        if (topicList.length > 2){
            System.out.println("无效主题");
            return false;
        }else {
            if (!topicList[1].equals("numerical") &&
            !topicList[1].equals("string") &&
            !topicList[1].equals("position")){
                System.out.println("无效主题");
                return false;
            }else {
                return true;
            }
        }
    }

    @Override
    public boolean updateOnlineStatus(String topic, String message) {
        System.out.println("这里上传设备的在线状态");
        return false;
    }

    @Override
    public boolean returnResponse(String topic, String message) {
        System.out.println("这里上传设备的响应数据");
        return false;
    }
}
