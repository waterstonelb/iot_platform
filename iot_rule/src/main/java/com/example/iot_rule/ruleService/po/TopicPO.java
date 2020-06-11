package com.example.iot_rule.ruleService.po;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/10 22:04
 * @Version 1.0
 */
@Setter
@Getter
public class TopicPO {
    private String topic;
    private Map map;

}
