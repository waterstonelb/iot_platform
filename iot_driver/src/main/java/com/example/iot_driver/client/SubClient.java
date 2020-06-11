package com.example.iot_driver.client;

import com.example.iot_driver.mqttCallBack.SubCallBack;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@DependsOn("subCallBack")
public class SubClient {

    @Value("${mqtt.host}")
    private String host;

    @Value("${mqtt.subClientId}")
    private String clientId;

    @Value("${mqtt.userName}")
    private String userName;

    @Value("${mqtt.password}")
    private String password;

    private MqttClient mqttClient;

    @Autowired
    private SubCallBack subCallBack;

    // 该注解的作用是在构造器实例化对象后调用次此方法
    @PostConstruct
    public void connect() throws MqttException {

        // MemoryPersistence设置客户端实例的保存形式，默认为以内存保存， 此处以内存保存
        mqttClient = new MqttClient(host,clientId,new MemoryPersistence());

        // 设置连接时的参数
        MqttConnectOptions options = new MqttConnectOptions();

        // 设置清除会话
        options.setCleanSession(false);
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

        mqttClient.setCallback(subCallBack);

        mqttClient.connect(options);

    }

    // 连接并订阅
    public void connectAndSubscribe() throws MqttException{
        // 主题
        String topic = "topic";
        mqttClient.subscribe(topic, 0);
    }

    // 增加订阅
    public void addSubscribe(String[] topics, int qos) throws MqttException{
        // 订阅
        int[] qoss = new int[topics.length];
        Arrays.fill(qoss, qos);
        mqttClient.subscribe(topics, qoss);
    }

    // 增加订阅
    public void addSubscribe(String[] topics, int[] qoss) throws MqttException{
        mqttClient.subscribe(topics,qoss);
    }

    // 取消订阅
    public void removeSubscribe(String[] topics) throws MqttException{
        mqttClient.unsubscribe(topics);
    }
}
