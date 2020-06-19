package com.example.iot_rule.ruleService.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/12 22:38
 * @Version 1.0
 */
@Setter
@Getter
public class DataTransmitTopicPO {
    private int id;
    private int ruleId;
    private String targetTopic;
    private Date createTime;
    private String type;
}
