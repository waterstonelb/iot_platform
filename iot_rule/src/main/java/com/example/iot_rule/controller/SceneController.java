package com.example.iot_rule.controller;

import com.example.iot_rule.ruleService.vo.ResponseEntity;
import com.example.iot_rule.sceneService.SceneService;
import com.example.iot_rule.sceneService.vo.SceneFormVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/10 21:17
 * @Version 1.0
 */
@RestController
@RequestMapping("/scene")
public class SceneController {
    @Autowired
    SceneService sceneService;

    @ApiOperation(value = "hello",notes = "hello")
    @GetMapping("/hello")
    public String test(){return "hello";}

    @ApiOperation(value = "添加场景联动",notes = "添加场景联动")
    @PostMapping("/addScene")
    public ResponseEntity<String> addScene(@RequestBody SceneFormVO sceneFormVO){
        return sceneService.addScene(sceneFormVO);
    }
}
