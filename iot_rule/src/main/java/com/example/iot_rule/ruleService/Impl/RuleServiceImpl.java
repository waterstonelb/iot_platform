package com.example.iot_rule.ruleService.Impl;

import com.example.iot_rule.ruleService.mapper.RuleServiceMapper;
import com.example.iot_rule.ruleService.po.RulePO;
import com.example.iot_rule.ruleService.RuleService;
import com.example.iot_rule.ruleService.vo.ResponseEntity;
import com.example.iot_rule.ruleService.vo.PageRequest;
import com.example.iot_rule.ruleService.vo.RuleFormVO;
import com.example.iot_rule.ruleService.vo.RuleVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
}
