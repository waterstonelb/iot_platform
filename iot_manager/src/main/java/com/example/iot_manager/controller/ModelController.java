package com.example.iot_manager.controller;

import com.example.iot_manager.data.ModelDo;
import com.example.iot_manager.service.ModelService;
import com.example.iot_manager.vo.ModelVO;
import com.example.iot_manager.vo.PageResult;
import com.example.iot_manager.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/model")
public class ModelController {

  final
  ModelService modelService;

  @Autowired
  public ModelController(ModelService modelService) {
    this.modelService = modelService;
  }

  @ApiOperation("添加模型")
  @PostMapping("/add")
  public ResponseVO<String> addModel(@RequestBody ModelVO modelVO){
    return modelService.addModel(modelVO);
  }

  @ApiOperation("更新模型")
  @PostMapping("/update")
  public ResponseVO<String> updateModel(@RequestParam int modelId, @RequestBody ModelVO modelVO){
    return modelService.updateModel(modelId, modelVO);
  }

  @ApiOperation("删除模型")
  @DeleteMapping("/delete")
  public ResponseVO<String> deleteModel(int modelId){
    return modelService.deleteModel(modelId);
  }

  @ApiOperation("获取全部模型")
  @GetMapping("/getall")
  public ResponseVO<PageResult<ModelDo>> getAllModel(int page, int size){
    return modelService.findAllModel(page, size);
  }

  @ApiOperation("根据modelId获取模型")
  @GetMapping("/get")
  public ResponseVO<ModelDo> getModel(int modelId){
    return modelService.findModel(modelId);
  }

}
