package com.example.iot_driver.client;

import com.example.iot_driver.mqttCallBack.PubCallBack;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PubClient {

    @Value("${mqtt.host}")
    private String host;

    @Value("${mqtt.pubClientId}")
    private String clientId;

    @Value("${mqtt.userName}")
    private String userName;

    @Value("${mqtt.password}")
    private String password;

    @Autowired
    private PubCallBack pubCallBack;

    private MqttClient mqttClient;

    // 该注解的作用是在构造器实例化对象后调用次此方法
    @PostConstruct
    public void connect() throws MqttException {
        // MemoryPersistence设置客户端实例的保存形式，默认为以内存保存， 此处以内存保存
        mqttClient = new MqttClient(host, clientId,new MemoryPersistence());

        // 设置连接时的参数 18
        MqttConnectOptions options = new MqttConnectOptions();

        // 设置清除会话
        options.setCleanSession(true);
        // 设置用户名
        options.setUserName(userName);
        // 设置密码
        options.setPassword(password.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(100);
        //设置心跳时间
        options.setKeepAliveInterval(180);
        // 掉线自动重连
        options.setAutomaticReconnect(true);
        /*
            遗嘱消息 ：当连接断开时发送的死亡预告，此客户端连接断开后，
           服务器会把此消息推送给订阅了此主题的客户机
           */
        options.setWill("close","offline".getBytes(),0,true);

        mqttClient.setCallback(pubCallBack);

        mqttClient.connect(options);

    }

    public void publish(MqttTopic mqttTopic, MqttMessage mqttMessage) throws MqttException{
        MqttDeliveryToken token = mqttTopic.publish(mqttMessage);
        token.waitForCompletion();
    }

    public void connectAndPublish() throws MqttException{
        String topic = "topic";
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setQos(0);
        mqttMessage.setRetained(false);
        // 发布消息内容
        String message = "测试连接发布订阅";
        mqttMessage.setPayload(message.getBytes());

        MqttTopic mqttTopic = mqttClient.getTopic(topic);
        System.out.println("发布者发布消息");
        publish(mqttTopic, mqttMessage);
    }

    // 增加发布
    public void addPublish(String topic, int qos, String message) throws MqttException{
       MqttMessage mqttMessage = new MqttMessage();
       mqttMessage.setQos(qos);
       mqttMessage.setRetained(false);
       mqttMessage.setPayload(message.getBytes());

       MqttTopic mqttTopic = mqttClient.getTopic(topic);
       publish(mqttTopic, mqttMessage);
    }
}
