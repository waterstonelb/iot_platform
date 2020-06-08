package com.example.iot_manager.controller;

import com.example.iot_manager.data.ModelDo;
import com.example.iot_manager.service.ModelService;
import com.example.iot_manager.vo.ModelVO;
import com.example.iot_manager.vo.ResponseVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/model")
public class ModelController {

  final
  ModelService modelService;

  @Autowired
  public ModelController(ModelService modelService) {
    this.modelService = modelService;
  }

  @PostMapping("/add")
  public ResponseVO<String> addModel(@RequestBody ModelVO modelVO){
    return modelService.addModel(modelVO);
  }

  @PostMapping("/update")
  public ResponseVO<String> updateModel(@RequestParam int modelId, @RequestBody ModelVO modelVO){
    return modelService.updateModel(modelId, modelVO);
  }

  @DeleteMapping("/delete")
  public ResponseVO<String> deleteModel(int modelId){
    return modelService.deleteModel(modelId);
  }

  @GetMapping("/getall")
  public ResponseVO<List<ModelDo>> getAllModel(int page, int size){
    return modelService.findAllModel(page, size);
  }

  @GetMapping("/get")
  public ResponseVO<ModelDo> getModel(int modelId){
    return modelService.findModel(modelId);
  }

}
