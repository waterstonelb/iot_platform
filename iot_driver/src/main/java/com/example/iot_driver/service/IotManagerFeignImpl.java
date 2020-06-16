package com.example.iot_driver.service;

import com.example.iot_driver.FeignVO.ResponseVO;
import com.example.iot_driver.FeignVO.StatusVO;
import com.example.iot_driver.client.IotManagerFeignClient;
import com.example.iot_driver.data.ModelMapper;
import com.example.iot_driver.mqttDeviceVo.DeviceLineStatusVo;
import com.example.iot_driver.mqttDeviceVo.DeviceTelemetryVo;
import com.example.iot_driver.vo.DataTransVO;
import com.example.iot_driver.vo.SimpleModelVO;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IotManagerFeignImpl {

    @Autowired
    private IotManagerFeignClient iotManagerFeignClient;

    @Autowired
    private ModelMapper modelMapper;

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
                System.out.println("message转DeviceLineStatusVo类型转换失败");
            }
        }else if (topicSub[topicSub.length-1].equals("telemetry")){
            try {
                Gson gson = new Gson();
                Map<String,Object> map = new HashMap<String, Object>();
                map = gson.fromJson(message, new TypeToken<Map<String,Object>>() {
                }.getType());
                DeviceTelemetryVo telemetryVo = new DeviceTelemetryVo();

                telemetryVo.setDeviceId(Integer.parseInt((String) map.get("deviceId")));
                Map<String,Object> map1 = (Map<String, Object>) map.get("properties");
                System.out.println(map1.get("temperature"));
                System.out.println(map1.get("press"));
                telemetryVo.setProperties(map1);
                transforData(telemetryVo);

            }catch (Exception e){
                e.printStackTrace();
                System.out.println("message转DeviceTelemetryVo类型转换失败");
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

    public void transforData(DeviceTelemetryVo telemetryVo){
        List<SimpleModelVO> modelVOList = new ArrayList<SimpleModelVO>();
        for (String key: telemetryVo.getProperties().keySet()){
            modelVOList.add(creatModel(key, telemetryVo.getProperties().get(key)));
        }

        Date date = new Date();
        DataTransVO transVO = new DataTransVO();
        transVO.setId(telemetryVo.getDeviceId());
        transVO.setModelVOs(modelVOList);
        transVO.setTime(date);
        try {
            System.out.println(transVO.toString());
            iotManagerFeignClient.transforData(transVO);
            System.out.println("数据传输到iot_manager成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据传输出错");
        }
    }

    public SimpleModelVO creatModel(String key, Object value){
        SimpleModelVO modelVO = new SimpleModelVO();
        modelVO.setModelId(modelMapper.getModelIdByAttr(key));
        modelVO.setNum(Integer.parseInt(value.toString()));
        return modelVO;
    }
}
