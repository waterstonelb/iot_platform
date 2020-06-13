package com.example.iot_driver.service.impl;

import com.example.iot_driver.data.TopicMapper;
import com.example.iot_driver.service.ICoreServiceInner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreServiceInner implements ICoreServiceInner {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public boolean initSub(){
        System.out.println("这里做重新订阅（结合实际业务）");
        return false;
    }

    // 这里判断主题是否有效
    @Override
    public boolean isValidTopic(String topic) {
        int deviceId = topicMapper.getDeviceIdByTopic(topic);
        System.out.println(deviceId);
        if (deviceId == -1){
            System.out.println("无效主题");
            return false;
        }else {
            System.out.println("主题有效");
            return true;
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
