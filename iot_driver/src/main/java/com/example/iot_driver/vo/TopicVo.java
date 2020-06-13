package com.example.iot_driver.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TopicVo {

    private Integer deviceId;

    private String topicName;

    private String describe;

    private String type;

    private Integer qos;

    private Integer level;

}
