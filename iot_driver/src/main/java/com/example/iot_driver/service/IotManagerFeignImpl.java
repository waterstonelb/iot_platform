package com.example.iot_driver.service;

import com.example.iot_driver.FeignVO.ResponseVO;
import com.example.iot_driver.FeignVO.StatusVO;
import com.example.iot_driver.client.IotManagerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IotManagerFeignImpl {

    @Autowired
    private IotManagerFeignClient iotManagerFeignClient;

    public void receiveData(String topic, String message){
        String[] topicSub = topic.split("/");
        if (topicSub[topicSub.length-1].equals("online")){
            uploadDeviceStatus(Integer.parseInt(topicSub[0]), 1);
        }else if (topicSub[topicSub.length-1].equals("offline")){
            uploadDeviceStatus(Integer.parseInt(topicSub[0]), 0);
        }
    }

    public void uploadDeviceStatus(int deviceId, int status){
        StatusVO statusVO = new StatusVO(deviceId, status);
        System.out.println(statusVO.toString());
        try {
            ResponseVO responseVO = iotManagerFeignClient.updateOnline(statusVO);
            System.out.println(responseVO.toString());
            System.out.println(responseVO.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println(iotManagerFeignClient.updateOnline(statusVO));
//        iotManagerFeignClient.updateOnline(statusVO);
    }
}
