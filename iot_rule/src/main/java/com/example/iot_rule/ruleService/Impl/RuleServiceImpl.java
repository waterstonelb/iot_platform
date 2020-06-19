package com.example.iot_rule.ruleService.Impl;

import com.example.iot_rule.ruleService.mapper.RuleServiceMapper;
import com.example.iot_rule.ruleService.po.DataTransmitHttpPO;
import com.example.iot_rule.ruleService.po.DataTransmitTopicPO;
import com.example.iot_rule.ruleService.po.RulePO;
import com.example.iot_rule.ruleService.RuleService;
import com.example.iot_rule.ruleService.po.TopicPO;
import com.example.iot_rule.ruleService.vo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/8 17:00
 * @Version 1.0
 */
@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleServiceMapper ruleServiceMapper;

    @Override
    public ResponseEntity<List<RuleVO>> getAllRules(@RequestBody PageRequest pageRequest){
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        PageInfo<RulePO> rulePOPageInfo=new PageInfo<>(ruleServiceMapper.getAllRules());
        return ResponseEntity.PageTool(rulePOPageInfo);
    }

    @Override
    public ResponseEntity<RuleVO> getRuleById(int id){
        RulePO rulePO=ruleServiceMapper.getRuleById(id);
        RuleVO ruleVO=new RuleVO(rulePO);
        return new ResponseEntity<>(ruleVO);

    }

    @Override
    public ResponseEntity<String> addRule(RuleFormVO ruleFormVO){
        int x=ruleServiceMapper.addRule(ruleFormVO);
        String msg="";
        if(x==1){
            msg="添加成功";
        }else if(x==0){
            msg="添加失败";
        }
        return new ResponseEntity<>(null,msg);
    }

    @Override
    public ResponseEntity<String> modifyRule(RuleVO ruleVO){
        int x=ruleServiceMapper.modifyRule(ruleVO);
        String msg="";
        if(x==1){
            msg="修改成功";
        }else if(x==0){
            msg="修改失败";
        }
        return new ResponseEntity<>(null,msg);
    }

    @Override
    public ResponseEntity<String> deleteRule(int id){
        int x=ruleServiceMapper.deleteRuleById(id);
        String msg="";
        if(x==1){
            msg="删除成功";
        }else if(x==0){
            msg="删除失败";
        }
        return new ResponseEntity<>(null,msg);
    }

    @Override
    public ResponseEntity<String> startRule(int id){
        int x=ruleServiceMapper.startRuleById(id);
        String msg="";
        if(x==1){
            msg="启动成功";
        }else if(x==0){
            msg="启动失败";
        }
        return new ResponseEntity<>(null,msg);
    }

    @Override
    public ResponseEntity<String> endRule(int id){
        int x=ruleServiceMapper.endRuleById(id);
        String msg="";
        if(x==1){
            msg="结束成功";
        }else if(x==0){
            msg="结束失败";
        }
        return new ResponseEntity<>(null,msg);
    }

    @Override
    public ResponseEntity<List<TopicVO>> handlerData(TopicPO topicPO){
        List<RulePO> rulePOS=ruleServiceMapper.selectRulesByTopic(topicPO.getTopic());//找出所有订阅该topic且处于开启状态的规则
        List<TopicVO> topicVOS=new ArrayList<>();
        for(RulePO rulePO:rulePOS){
            String condition=rulePO.getCondition();
            if(condition.contains("=")){
                String [] strArr=condition.split("=");
                if(topicPO.getMap().containsKey(strArr[0])){
                    if(isDigit(strArr[1])){
                        int x=Integer.parseInt(strArr[1]);
                        if(topicPO.getMap().get(strArr[0]).equals(x)){    //规则引擎接收到订阅的topic发来的消息
                            TopicVO topicVO=new TopicVO();
                            topicVO.setRuleId(rulePO.getId());
                            topicVO.setMap(topicPO.getMap());
                            topicVOS.add(topicVO);
                            System.out.println(rulePO.getTarget()+":"+topicPO.getMap().get(rulePO.getTarget()));
                        }
                    }else {
                        if(topicPO.getMap().get(strArr[0]).equals(strArr[1])){
                            TopicVO topicVO=new TopicVO();
                            topicVO.setRuleId(rulePO.getId());
                            topicVO.setMap(topicPO.getMap());
                            topicVOS.add(topicVO);
                            System.out.println(rulePO.getTarget()+":"+topicPO.getMap().get(rulePO.getTarget()));
                        }
                    }
                }
            }else if(condition.contains(">")){
                String [] strArr=condition.split(">");
                if(topicPO.getMap().containsKey(strArr[0])){
                    if((Integer)topicPO.getMap().get(strArr[0])>Integer.parseInt(strArr[1])){
                        TopicVO topicVO=new TopicVO();
                        topicVO.setRuleId(rulePO.getId());
                        topicVO.setMap(topicPO.getMap());
                        topicVOS.add(topicVO);
                        System.out.println(rulePO.getTarget()+":"+topicPO.getMap().get(rulePO.getTarget()));
                    }
                }
            }else if(condition.contains("<")){
                String [] strArr=condition.split("<");
                if(topicPO.getMap().containsKey(strArr[0])){
                    if((Integer)topicPO.getMap().get(strArr[0])<Integer.parseInt(strArr[1])){
                        TopicVO topicVO=new TopicVO();
                        topicVO.setRuleId(rulePO.getId());
                        topicVO.setMap(topicPO.getMap());
                        topicVOS.add(topicVO);
                        System.out.println(rulePO.getTarget()+":"+topicPO.getMap().get(rulePO.getTarget()));
                    }
                }
            }
        }
        return new ResponseEntity<>(topicVOS);
    }

    @Override
    public ResponseEntity<String> dataTransmitTopic(DataTransmitTopicFormVO dataTransmitTopicFormVO){
        DataTransmitTopicPO dataTransmitTopicPO=new DataTransmitTopicPO();
        dataTransmitTopicPO.setRuleId(dataTransmitTopicFormVO.getRuleId());
        dataTransmitTopicPO.setTargetTopic(dataTransmitTopicFormVO.getTargetTopic());
        dataTransmitTopicPO.setType("TOPIC");
        int x=ruleServiceMapper.addDataTransmitTopic(dataTransmitTopicPO);
        String msg="";
        if(x==1){
            msg="创建数据转发成功";
        }else if(x==0){
            msg="创建数据转发失败";
        }
        return new ResponseEntity<>(null,msg);
    }

    @Override
    public ResponseEntity<String> dataTransmitHttp(DataTransmitHttpFormVO dataTransmitHttpFormVO){
        DataTransmitHttpPO dataTransmitHttpPO=new DataTransmitHttpPO();
        dataTransmitHttpPO.setRuleId(dataTransmitHttpFormVO.getRuleId());
        dataTransmitHttpPO.setTransmitAddress(dataTransmitHttpFormVO.getHttpInterface());
        dataTransmitHttpPO.setType("HTTP");
        int x=ruleServiceMapper.addDataTransmitHttp(dataTransmitHttpPO);
        String msg="";
        if(x==1){
            msg="创建数据转发成功";
        }else if(x==0){
            msg="创建数据转发失败";
        }
        return new ResponseEntity<>(null,msg);
    }

    @Override
    public ResponseEntity<List<DataTransmitHttpPO>> getAllDataTransmitHttp(int id){
        return new ResponseEntity<>(ruleServiceMapper.getAllDataTransmitHttp(id));
    }

    @Override
    public ResponseEntity<List<DataTransmitTopicPO>> getAllDataTransmitTopic(int id){
        return new ResponseEntity<>(ruleServiceMapper.getAllDataTransmitTopic(id));
    }


    private boolean isDigit(String str){
        try {
            int num= Integer.parseInt(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
