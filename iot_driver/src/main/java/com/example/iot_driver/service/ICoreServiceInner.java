package com.example.iot_driver.service;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface ICoreServiceInner {

    /**初始化（重连）订阅*/
    boolean initSub() throws MqttException;

    /**判断主题是否有效*/
    boolean isValidTopic(String topic);

    /**更新设备在线状态*/
    boolean updateOnlineStatus(String topic, String message);

    /** 上传设备的控制响应*/
    boolean returnResponse(String topic, String message);
}
