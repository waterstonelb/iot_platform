package com.example.iot_rule.controller;

import com.example.iot_rule.ruleService.RuleService;
import com.example.iot_rule.ruleService.po.DataTransmitHttpPO;
import com.example.iot_rule.ruleService.po.DataTransmitTopicPO;
import com.example.iot_rule.ruleService.po.TopicPO;
import com.example.iot_rule.ruleService.vo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rules")
public class RuleController {
    @Autowired
    RuleService ruleService;

    @ApiOperation(value = "hello world",notes = "测试")
    @GetMapping("/hello")
    public String test(){
        return "hello world";
    }

    @ApiOperation(value = "查询所有规则引擎",notes = "返回一个规则引擎列表")
    @PostMapping("/allRules")
    public ResponseEntity<List<RuleVO>> getAllRules(@RequestBody PageRequest pageRequest){
        return ruleService.getAllRules(pageRequest);
    }

    @ApiOperation(value = "根据id查找规则引擎的具体信息",notes = "返回一个实体类，包括规则引擎的具体内容")
    @GetMapping("/rule")
    public ResponseEntity<RuleVO> getRuleById(int id){
        return ruleService.getRuleById(id);
    }

    @ApiOperation(value = "新增一个规则引擎",notes = "新增一个规则引擎")
    @PostMapping("/add")
    public ResponseEntity<String> addRule(@RequestBody RuleFormVO ruleFormVO){
        return ruleService.addRule(ruleFormVO);
    }

    @ApiOperation(value = "删除一个规则引擎",notes = "根据id删除规则引擎")
    @GetMapping("/delete")
    public ResponseEntity<String> deleteRule(int id){
        return ruleService.deleteRule(id);
    }

    @ApiOperation(value = "修改规则引擎",notes = "根据id修改规则引擎")
    @PostMapping("/modify")
    public ResponseEntity<String> modifyRule(@RequestBody RuleVO ruleVO){
        return ruleService.modifyRule(ruleVO);
    }

    @ApiOperation(value = "启动一个规则引擎",notes = "根据id启动一个规则引擎")
    @GetMapping("/start")
    public ResponseEntity<String> startRule(int id){
        return ruleService.startRule(id);
    }

    @ApiOperation(value = "结束一个规则引擎",notes = "根据id结束一个规则引擎")
    @GetMapping("/end")
    public ResponseEntity<String> endRule(int id){
        return ruleService.endRule(id);
    }

    @ApiOperation(value = "接收设备上传的数据测试接口（cp用这个）",notes = "给cp测试用的")
    @PostMapping("/dataTest")
    public ResponseEntity<TopicPO> receiveDataTest(@RequestBody TopicPO topicPO){
        return new ResponseEntity<TopicPO>(topicPO);
    }

    @ApiOperation(value = "接收设备上传的数据（不是给cp用的）",notes = "")
    @PostMapping("/data")
    public ResponseEntity<List<TopicVO>> receiveData(@RequestBody TopicPO topicPO){

        return ruleService.handlerData(topicPO);
    }

    @ApiOperation(value = "为规则引擎配置数据转发",notes = "转发数据到另一个Topic")
    @PostMapping("/dataTransmitTopic")
    public ResponseEntity<String> dataTransmitTopic(@RequestBody DataTransmitTopicFormVO dataTransmitTopicFormVO){
        return ruleService.dataTransmitTopic(dataTransmitTopicFormVO);
    }

    @ApiOperation(value = "为规则引擎配置数据转发",notes = "转发数据到HTTP接口")
    @PostMapping("/dataTransmitHttp")
    public ResponseEntity<String> dataTransmitHttp( @RequestBody DataTransmitHttpFormVO dataTransmitHttpFormVO){
        return ruleService.dataTransmitHttp(dataTransmitHttpFormVO);
    }

    @ApiOperation(value = "根据id查看所有http规则引擎")
    @GetMapping("/allDataTransmitHttp")
    public ResponseEntity<List<DataTransmitHttpPO>> getAllDataTransmitHttp(int id){
        return ruleService.getAllDataTransmitHttp(id);
    }

    @ApiOperation(value = "根据id查看所有topic规则引擎")
    @GetMapping("/allDataTransmitTopic")
    public ResponseEntity<List<DataTransmitTopicPO>> getAllDataTransmitTopic(int id){
        return ruleService.getAllDataTransmitTopic(id);
    }


}
