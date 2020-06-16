package com.example.iot_rule.sceneService;

import com.example.iot_rule.ruleService.vo.ResponseEntity;
import com.example.iot_rule.sceneService.vo.SceneFormVO;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/13 14:12
 * @Version 1.0
 */
public interface SceneService {

    ResponseEntity<String> addScene(SceneFormVO sceneFormVO);
}
