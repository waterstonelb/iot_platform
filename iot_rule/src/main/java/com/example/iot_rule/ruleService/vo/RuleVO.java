package com.example.iot_rule.ruleService.vo;

import com.example.iot_rule.ruleService.po.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Name:
 * DESCRIPTION: 从前端获取的用户填写的相关信息
 *
 * @author 孙刘博
 * @date 2020/6/8 17:11
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleVO {
    private int id;
    private String description;
    private int state;
    private int userId;
    private int deviceId;
    private Date createTime;
    private String target;
    private String topic;
    private String condition;

    public RuleVO(RulePO rulePO){
        this.id=rulePO.getId();
        this.description=rulePO.getDescription();
        this.state=rulePO.getState();
        this.userId=rulePO.getUserId();
        this.deviceId=rulePO.getDeviceId();
        this.createTime=rulePO.getCreateTime();
        this.target=rulePO.getTarget();
        this.topic=rulePO.getTopic();
        this.condition=rulePO.getCondition();
    }

}
