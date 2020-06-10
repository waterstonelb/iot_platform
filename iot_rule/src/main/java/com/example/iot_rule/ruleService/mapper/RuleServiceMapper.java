package com.example.iot_rule.ruleService.mapper;

import com.example.iot_rule.ruleService.po.RulePO;
import com.example.iot_rule.ruleService.vo.RuleFormVO;
import com.example.iot_rule.ruleService.vo.RuleVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/8 17:30
 * @Version 1.0
 */
@Component
@Mapper
public interface RuleServiceMapper {

    List<RulePO> getAllRules();

    RulePO getRuleById(int id);

    int addRule(RuleFormVO ruleFormVO);

    int modifyRule(RuleVO ruleVO);

    int deleteRuleById(int id);

    int startRuleById(int id);

    int endRuleById(int id);

}
