package com.example.iot_rule.sceneService.po;

import lombok.Getter;
import lombok.Setter;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/13 14:16
 * @Version 1.0
 */
@Setter
@Getter
public class ScenePO {
    private int id;
    private int rule_id;
    private int deviceId;//绑定的设备id,比如温度报警器
    private String condition;
    private String action;
}
