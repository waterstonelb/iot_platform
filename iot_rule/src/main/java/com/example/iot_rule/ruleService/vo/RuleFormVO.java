package com.example.iot_rule.ruleService.vo;

import lombok.*;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/9 16:36
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleFormVO {
    private String description;
    private int userId;
    private int deviceId;
    private String target;
    private String topic;
    private String condition;

}
