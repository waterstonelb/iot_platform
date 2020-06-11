package com.example.iot_driver.service;

import com.example.iot_driver.client.IotRuleFeignClient;
import com.example.iot_driver.vo.TopicPO;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataForwarding {

    @Autowired
    private IotRuleFeignClient iotRuleFeignClient;

    public void transport(String topic, String message){
        TopicPO topicPO = new TopicPO();

        Gson gson = new Gson();
        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap = gson.fromJson(message, new TypeToken<Map<String, Object>>() {
        }.getType());
        System.out.println(hashMap);

        topicPO.setTopic(topic);
        topicPO.setMap(hashMap);

        System.out.println(iotRuleFeignClient.receiveDataTest(topicPO).toString());
    }

    public static Map<String,Object> getStringToMap(String str){
        //根据逗号截取字符串数组
        String[] str1 = str.split(",");
        //创建Map对象
        Map<String,Object> map = new HashMap<>();
        //循环加入map集合
        for (int i = 0; i < str1.length; i++) {
            //根据":"截取字符串数组
            String[] str2 = str1[i].split(":");
            //str2[0]为KEY,str2[1]为值
            map.put(str2[0],str2[1]);
        }
        return map;
    }
}
