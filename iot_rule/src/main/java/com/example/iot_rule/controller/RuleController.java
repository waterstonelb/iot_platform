package com.example.iot_rule.controller;

import com.example.iot_rule.ruleService.RuleService;
import com.example.iot_rule.ruleService.vo.PageRequest;
import com.example.iot_rule.ruleService.vo.ResponseEntity;
import com.example.iot_rule.ruleService.vo.RuleFormVO;
import com.example.iot_rule.ruleService.vo.RuleVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RuleController {
    @Autowired
    RuleService ruleService;

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


}
