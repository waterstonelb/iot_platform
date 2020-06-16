package com.example.iot_rule.sceneService.Impl;

import com.example.iot_rule.ruleService.vo.ResponseEntity;
import com.example.iot_rule.sceneService.SceneService;
import com.example.iot_rule.sceneService.mapper.SceneServiceMapper;
import com.example.iot_rule.sceneService.vo.SceneFormVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/13 14:13
 * @Version 1.0
 */
@Service
public class SceneServiceImpl implements SceneService {
    @Autowired
    private SceneServiceMapper sceneServiceMapper;

    @Override
    public ResponseEntity<String> addScene(SceneFormVO sceneFormVO){
        int x=sceneServiceMapper.addScene(sceneFormVO);
        String msg="";
        if(x==1){
            msg="添加成功";
        }else if(x==0){
            msg="添加失败";
        }
        return new ResponseEntity<>(null,msg);
    }
}