package com.example.iot_rule.ruleService;

import com.example.iot_rule.ruleService.po.DataTransmitHttpPO;
import com.example.iot_rule.ruleService.po.DataTransmitTopicPO;
import com.example.iot_rule.ruleService.po.TopicPO;
import com.example.iot_rule.ruleService.vo.*;
import net.sf.jsqlparser.statement.select.Top;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/8 16:59
 * @Version 1.0
 */
public interface RuleService {

    ResponseEntity<List<RuleVO>> getAllRules(@RequestBody PageRequest pageRequest);

    ResponseEntity<RuleVO> getRuleById(int id);

    ResponseEntity<String> addRule(RuleFormVO ruleFormVO);

    ResponseEntity<String> modifyRule(RuleVO ruleVO);

    ResponseEntity<String> deleteRule(int id);

    ResponseEntity<String> startRule(int id);

    ResponseEntity<String> endRule(int id);

    ResponseEntity<List<TopicVO>> handlerData(TopicPO topicPO);

    ResponseEntity<String> dataTransmitTopic(DataTransmitTopicFormVO dataTransmitTopicFormVO);

    ResponseEntity<String> dataTransmitHttp(DataTransmitHttpFormVO dataTransmitHttpFormVO);

    ResponseEntity<List<DataTransmitHttpPO>> getAllDataTransmitHttp(int id);

    ResponseEntity<List<DataTransmitTopicPO>> getAllDataTransmitTopic(int id);


}
