package com.example.iot_driver.mqttCallBack;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("subCallBackService")
// 注解标示SubCallBack 的实例化依赖 SubCallBackService，即 SubCallBackService先实例化后，再实例化SubCallBack
public class SubCallBack implements MqttCallbackExtended {

    @Autowired
    private SubCallBackService subCallBackService;
    private MqttClient mqttClient;

    // 连接成功后会调用此方法
    @Override
    public void connectComplete(boolean reconnect, String serverURI) {
        System.out.println("订阅者连接成功");
        // 重连需要重新订阅主题
        if (reconnect){
            System.out.println("重连成功s");
        }
    }

    // 在断开连接时调用
    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("订阅者断开连接，可以做重连");
    }

    // 接收已经预订的发布
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
//        System.out.println("收到消息主题：" + topic);
//        System.out.println("收到消息内容：" + message);
        String msg = message.toString();
        if (msg.trim().length() > 0) {
            // trim去除字符串首尾空格
            subCallBackService.messageHandle(topic, msg);
        }
    }

    // 接收已经发布的 QoS 1 或 QoS 2 消息的传递令牌时调用
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("消息接收完成");
    }
}
