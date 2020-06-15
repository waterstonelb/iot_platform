package com.example.iot_driver.service;

import com.example.iot_driver.FeignVO.TopicPO;
import com.example.iot_driver.client.IotRuleFeignClient;
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

    public void receiveData(String topic, String message){
        String[] topicSub = topic.split("/");
        if (!topicSub[topicSub.length-1].equals("online") &&
                !topicSub[topicSub.length-1].equals("offline")){
            if (topicSub[topicSub.length-1].equals("telemetry")){
                transport(topic,message);
            }
        }
    }

    public void transport(String topic, String message){
        try {
            TopicPO topicPO = new TopicPO();
            Gson gson = new Gson();
            Map<String, Object> hashMap = new HashMap<String, Object>();
            hashMap = gson.fromJson(message, new TypeToken<Map<String, Object>>() {
            }.getType());
            System.out.println(hashMap);

            Map<String,Object> map = (Map<String, Object>) hashMap.get("properties");
            topicPO.setTopic(topic);
            topicPO.setMap(map);
            System.out.println(topicPO.toString());
            try {
                iotRuleFeignClient.receiveData(topicPO);
                System.out.println("数据传输到iot_rule成功");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("传输失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("message转换topicPO失败");
        }
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
