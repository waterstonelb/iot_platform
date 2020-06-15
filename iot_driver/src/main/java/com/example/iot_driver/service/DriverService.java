package com.example.iot_driver.service;

import com.example.iot_driver.data.DriverMapper;
import com.example.iot_driver.data.TopicMapper;
import com.example.iot_driver.mqttTopics.MqttDefaultTopics;
import com.example.iot_driver.vo.ResponseVO;
import com.example.iot_driver.vo.SimpleDeviceVO;
import com.example.iot_driver.vo.TopicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DriverService {

    @Autowired
    private ICoreServiceOuter coreServiceOuter;

//    @Autowired
//    private DriverMapper driverMapper;

    @Autowired
    private TopicMapper topicMapper;

//    public ResponseVO addConnect(DeviceConnectInfo deviceConnectInfo){
//        if (driverMapper.addConnect(deviceConnectInfo) > 0){
//            return ResponseVO.buildSuccess("连接信息创建成功");
//        }else {
//            return ResponseVO.buildFailure("连接信息创建失败");
//        }
//    }
//
//    public ResponseVO modifyConnectInfo(DeviceConnectInfo deviceConnectInfo){
//        int status = driverMapper.getStatus(deviceConnectInfo.getDeviceId());
//        if (status == 1){
//            return ResponseVO.buildFailure("设备必须离线才能修改");
//        }else {
//            if (driverMapper.modifyConnectInfo(deviceConnectInfo) > 0){
//                return ResponseVO.buildSuccess("更新成功");
//            }else {
//                return ResponseVO.buildFailure("更新失败");
//            }
//        }
//    }
//
//    public ResponseVO getConnectInfo(String deviceId){
//        return ResponseVO.buildSuccess(driverMapper.getConnectInfo(deviceId));
//    }

//    public ResponseVO deviceOnline(String deviceId){
//        String[] topic = new String[] {deviceId+ "/+"};
//        int qos = driverMapper.getQosById(deviceId);
//        boolean b = coreServiceOuter.addSub(topic, qos);
//        if (b){
//            // 1表示设备在线
//            int n = driverMapper.updateStatus(1, deviceId);
//            if (n > 0){
//                return ResponseVO.buildSuccess("设备上线成功");
//            }else {
//                return ResponseVO.buildFailure("设备状态更新失败");
//            }
//        }else {
//            return ResponseVO.buildFailure("订阅设备主题失败");
//        }
//    }
//
//    public ResponseVO deviceOffline(String deviceId){
//        String[] topic = new String[] {deviceId+ "/+"};
//        boolean success = coreServiceOuter.removeSub(topic);
//        if (success){
//            // 0表示设备离线
//            int n = driverMapper.updateStatus(0, deviceId);
//            if (n > 0){
//                return ResponseVO.buildSuccess("设备离线成功");
//            }else {
//                return ResponseVO.buildFailure("设备状态更新失败");
//            }
//        }else {
//            return ResponseVO.buildFailure("取消订阅设备主题失败");
//        }
//    }

    public ResponseVO addDevice(SimpleDeviceVO deviceVO){
        int n = topicMapper.addDevice(creatTopic(deviceVO.getDeviceId()));
        if (n > 0){
            return ResponseVO.buildSuccess("插入成功");
        }else {
            return ResponseVO.buildFailure("插入失败");
        }
    }

//    public ResponseVO sendMessageToDevice(String deviceId, String message){
//        HashMap hashMap = driverMapper.getStatusAndQos(deviceId);
//        System.out.println(hashMap.toString());
//        // 这里应该判断设备是否离线 离线则应该将数据发往影子设备
//        boolean success = coreServiceOuter.addPub(deviceId, (Integer) hashMap.get("qos"), message);
//        if (success){
//            return ResponseVO.buildSuccess("消息发送成功");
//        }else {
//            return ResponseVO.buildFailure("消息发送失败");
//        }
//    }

    public ResponseVO activateDevice(int deviceId){
        List<Map<String, Object>> subList = topicMapper.getAllSub(deviceId);
        String[] topics = new String[subList.size()];
        int[] qoss = new int[subList.size()];
        for (int i=0;i<subList.size();i++){
            System.out.println(subList.get(i).get("topicName"));
            System.out.println(subList.get(i).get("qos"));
            topics[i] = (String) subList.get(i).get("topicName");
            qoss[i] = (int) subList.get(i).get("qos");
        }
        if (coreServiceOuter.addSub(topics, qoss)){
            return ResponseVO.buildSuccess("订阅成功");
        }else {
            return ResponseVO.buildFailure("订阅失败");
        }
    }

    public ResponseVO disable(int deviceId){
        List<Map<String, Object>> subList = topicMapper.getAllSub(deviceId);
        String[] topics = new String[subList.size()];
        for (int i=0;i<subList.size();i++){
            topics[i] = (String) subList.get(i).get("topicName");
        }
        if (coreServiceOuter.removeSub(topics)){
            return ResponseVO.buildSuccess("取消订阅成功");
        }else {
            return ResponseVO.buildFailure("取消订阅失败");
        }
    }

    public List<TopicVo> creatTopic(int deviceId){

        TopicVo topicVo1 = new TopicVo(deviceId, deviceId+"/online",
                "设备上线", "subscribe", 0, 0);

        TopicVo topicVo2 = new TopicVo(deviceId, deviceId+"/offline",
                "设备离线", "subscribe", 0, 0);

        TopicVo topicVo3 = new TopicVo(deviceId, deviceId+"/attributes/request",
                "请求设备属性", "publish", 0, 0);

        TopicVo topicVo4 = new TopicVo(deviceId, deviceId+"/attributes/response",
                "设备属性响应", "subscribe", 0, 0);


        TopicVo topicVo5 = new TopicVo(deviceId, deviceId+"/instruction/request",
                "向设备下发指令", "publish", 0, 0);

        TopicVo topicVo6 = new TopicVo(deviceId, deviceId+"/instruction/response",
                "设备指令响应结果", "subscribe", 0, 0);

        TopicVo topicVo7 = new TopicVo(deviceId, deviceId+"/telemetry",
                "设备遥测数据上传", "subscribe", 0, 0);

        List<TopicVo> topicVoList = new ArrayList<TopicVo>();
        topicVoList.add(topicVo1);
        topicVoList.add(topicVo2);
        topicVoList.add(topicVo3);
        topicVoList.add(topicVo4);
        topicVoList.add(topicVo5);
        topicVoList.add(topicVo6);
        topicVoList.add(topicVo7);
        return topicVoList;
    }
}
