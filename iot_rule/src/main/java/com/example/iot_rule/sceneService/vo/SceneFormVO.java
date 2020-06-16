package com.example.iot_rule.sceneService.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/15 11:07
 * @Version 1.0
 */
@Setter
@Getter
public class SceneFormVO {
    private int deviceId;
    private String condition;
    private String action;
}
