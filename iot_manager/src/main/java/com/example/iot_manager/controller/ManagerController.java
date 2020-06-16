package com.example.iot_manager.controller;

import com.example.iot_manager.client.DataServiceClient;
import com.example.iot_manager.service.ManagerService;
import com.example.iot_manager.vo.DataTransList;
import com.example.iot_manager.vo.DataTransVO;
import com.example.iot_manager.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/dt")
public class ManagerController {

  final
  DataServiceClient serviceClient;
  final
  ManagerService managerService;

  public ManagerController(DataServiceClient serviceClient,
      ManagerService managerService) {
    this.serviceClient = serviceClient;
    this.managerService = managerService;
  }

  @ApiOperation("设备数据传输")
  @PostMapping("/transfor")
  public ResponseVO<String> transforData(@RequestBody DataTransVO dataTransVO){
    if(!checkParam(dataTransVO))
      return ResponseVO.buildFailure("参数错误，请检查id，time，属性 是否为空");
    /*
    向data service传递数据
     */
    DataTransList transList = new DataTransList(managerService.setAttr(dataTransVO));
    log.info(transList.toString());
    serviceClient.addDevicedata(transList);
    return ResponseVO.buildSuccess("success");
  }

  private boolean checkParam(DataTransVO dataTransVO){
    return null != dataTransVO.getId() && null != dataTransVO.getTime() && !CollectionUtils.isEmpty(dataTransVO.getModelVOS());
  }

}
