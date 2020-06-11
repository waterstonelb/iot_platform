package com.example.iot_driver.controller;

import com.example.iot_driver.service.TopicService;
import com.example.iot_driver.vo.ResponseVO;
import com.example.iot_driver.vo.TopicVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("主题管理")
public class TopicController {

    @Autowired
    private TopicService topicService;

    /** 获取指定设备的所有主题*/
    @ApiOperation(value = "获取指定设备的所有主题")
    @RequestMapping(value = "/getTopic/{deviceId}", method = RequestMethod.GET)
    public ResponseVO getTopic(@PathVariable("deviceId") int deviceId){
        return topicService.getTopic(deviceId);
    }

    /** 给设备增加主题*/
    @ApiOperation(value = "给设备增加主题", notes = "给设备增加主题")
    @RequestMapping(value = "/addTopic", method = RequestMethod.POST)
    public ResponseVO addTopic(@RequestBody TopicVo topicVo){
        return topicService.addTopic(topicVo);
    }

    /** 删除设备主题*/
    @ApiOperation(value = "删除设备主题")
    @RequestMapping(value = "/deleteTopic", method = RequestMethod.GET)
    public ResponseVO deleteTopic(@RequestParam("topicName") String topicName){
        return topicService.deleteTopic(topicName);
    }

    /** 修改设备主题描述*/
    @ApiOperation(value = "修改设备主题描述，不支持修改其它信息")
    @RequestMapping(value = "/modifyDescribe", method = RequestMethod.POST)
    public ResponseVO modifyDescribe(@RequestParam("topicName") String topicName,
                                     @RequestBody String describe){
        System.out.println(topicName);
        System.out.println(describe);
        return topicService.modifyDescribe(topicName, describe);
    }

    /** 使用指定主题发送消息*/
    @ApiOperation(value = "向指定主题发送信息")
    @RequestMapping(value = "/sentMessage", method = RequestMethod.POST)
    public ResponseVO sentMessage(@RequestParam("topicName") String topicName,
                                  @RequestParam("qos") int qos,
                                  @RequestBody String message){
        System.out.println(topicName);
        System.out.println(qos);
        System.out.println(message);
        return topicService.sentMessage(topicName, qos, message);
    }
}
