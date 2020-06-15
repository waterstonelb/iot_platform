package com.example.iot_driver.service;

import com.example.iot_driver.FeignVO.ResponseVO;
import com.example.iot_driver.FeignVO.StatusVO;
import com.example.iot_driver.client.IotManagerFeignClient;
import com.example.iot_driver.mqttDeviceVo.DeviceLineStatusVo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IotManagerFeignImpl {

    @Autowired
    private IotManagerFeignClient iotManagerFeignClient;

    public void receiveData(String topic, String message){
        String[] topicSub = topic.split("/");
        if (topicSub[topicSub.length-1].equals("online") ||
                topicSub[topicSub.length-1].equals("offline")){
            try {
                Gson gson = new Gson();
                DeviceLineStatusVo deviceLineStatusVo = gson.fromJson(message, DeviceLineStatusVo.class);
                // 通知设备管理设备上线
                uploadDeviceStatus(deviceLineStatusVo);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("类型转换失败");
            }
        }
    }

    public void uploadDeviceStatus(DeviceLineStatusVo deviceLineStatusVo){
        StatusVO statusVO = new StatusVO(deviceLineStatusVo.getDeviceId(),deviceLineStatusVo.getStatus());
        System.out.println(statusVO.toString());
        try {
            ResponseVO responseVO = iotManagerFeignClient.updateOnline(statusVO);
            System.out.println(responseVO.toString());
            System.out.println(responseVO.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
