package com.example.iot_manager.controller;

import com.example.iot_manager.service.ShadowService;
import com.example.iot_manager.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shadow")
public class ShadowController {

  final
  ShadowService shadowService;

  @Autowired
  public ShadowController(ShadowService shadowService) {
    this.shadowService = shadowService;
  }

  @ApiOperation("获取设备影子")
  @GetMapping("/get")
  public ResponseVO<String> getShadow(int deviceId){
    return shadowService.getShadowByDevice(deviceId);
  }

  @ApiOperation("更新设备影子")
  @GetMapping("/update")
  public ResponseVO<String> updateShadow(int shadowId){
    return shadowService.updateShadow(shadowId);
  }

}
