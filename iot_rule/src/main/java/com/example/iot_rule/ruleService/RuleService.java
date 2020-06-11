package com.example.iot_rule.ruleService;

import com.example.iot_rule.ruleService.vo.PageRequest;
import com.example.iot_rule.ruleService.vo.ResponseEntity;
import com.example.iot_rule.ruleService.vo.RuleFormVO;
import com.example.iot_rule.ruleService.vo.RuleVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

}
