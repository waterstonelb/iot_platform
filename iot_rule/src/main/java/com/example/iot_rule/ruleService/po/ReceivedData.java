package com.example.iot_rule.ruleService.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/19 16:21
 * @Version 1.0
 */
@Getter
@Setter
public class ReceivedData {
    private int id;
    private int ruleId;
    private String map;
    private Date captureTime;
}
