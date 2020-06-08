package com.example.iot_driver.mqttCallBack;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

@Component
public class PubCallBack implements MqttCallbackExtended {

    // 连接成功后会调用此方法
    @Override
    public void connectComplete(boolean reconnect, String serverURI) {
        System.out.println("发布者连接成功");
    }

    //在断开连接时调用
    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("发布者断开连接，可以做重连");
    }

    // 接收已经预订的发布
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("发布消息主题：" + topic);
        System.out.println("发布消息内容：" + message);
    }

    //接收已经发布的 QoS 1 或 QoS 2 消息的传递令牌时调用
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("消息发布完成");
    }
}
