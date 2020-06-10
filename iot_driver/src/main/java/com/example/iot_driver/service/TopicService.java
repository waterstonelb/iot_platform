package com.example.iot_driver.service;

import com.example.iot_driver.data.TopicMapper;
import com.example.iot_driver.vo.ResponseVO;
import com.example.iot_driver.vo.TopicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private ICoreServiceOuter coreServiceOuter;

    @Autowired
    private TopicMapper topicMapper;

    /** 获取指定设备的所有主题*/
    public ResponseVO getTopic(int deviceId){
       return ResponseVO.buildSuccess(topicMapper.getTopic(deviceId));
    }

    /** 给设备增加主题*/
    public ResponseVO addTopic(TopicVo topicVo){
        int n = topicMapper.addTopic(topicVo);
        if (n > 0) {
            return ResponseVO.buildSuccess("插入成功");
        }else {
            return ResponseVO.buildFailure("插入失败");
        }
    }

    /** 删除设备主题*/
    public ResponseVO deleteTopic(String topicName){
        int n = topicMapper.deleteTopic(topicName);
        if (n > 0) {
            return ResponseVO.buildSuccess("删除成功");
        }else {
            return ResponseVO.buildFailure("删除失败");
        }
    }

    /** 修改设备主题描述*/
    public ResponseVO modifyDescribe(String topicName,String describe){
        int n = topicMapper.modifyDescribe(topicName, describe);
        if (n > 0) {
            return ResponseVO.buildSuccess("修改成功");
        }else {
            return ResponseVO.buildFailure("修改失败");
        }
    }

    public ResponseVO sentMessage(String topicName,int qos, String message){
        if (coreServiceOuter.addPub(topicName, qos, message)){
            return ResponseVO.buildSuccess("消息发布成功");
        }else {
            return ResponseVO.buildFailure("消息发布失败");
        }
    }
}
