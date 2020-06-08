package com.example.iot_driver.service.impl;

import com.example.iot_driver.client.PubClient;
import com.example.iot_driver.client.SubClient;
import com.example.iot_driver.service.ICoreServiceOuter;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreServiceOuter implements ICoreServiceOuter {

    @Autowired
    private SubClient subClient;

    @Autowired
    private PubClient pubClient;

    @Override
    public boolean addSub(String[] topics, int qos) {
        try {
            if (qos != 0 && qos != 1 && qos != 2){
                qos = 0;
            }
            subClient.addSubscribe(topics, qos);
            return true;
        }catch (MqttException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addPub(String topic, int qos, String message) {
        try {
            if (qos != 0 && qos != 1 && qos != 2){
                qos = 0;
            }
            pubClient.addPublish(topic, qos, message);
            return true;
        }catch (MqttException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeSub(String[] topics) {
        try {
            subClient.removeSubscribe(topics);
            return true;
        } catch (MqttException e) {
            e.printStackTrace();
            return false;
        }
    }
}
