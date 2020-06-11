package com.example.iot_rule.ruleService.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/8 17:32
 * @Version 1.0
 */
@Setter
@Getter
public class RulePO {
    private Integer id;
    private String description;
    private int state;
    private int userId;
    private int deviceId;
    private String target;
    private String topic;
    private String condition;
    private Date createTime;
}
