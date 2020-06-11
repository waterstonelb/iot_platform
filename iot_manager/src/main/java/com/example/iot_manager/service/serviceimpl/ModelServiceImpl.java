package com.example.iot_manager.service.serviceimpl;

import com.example.iot_manager.dao.ModelRepository;
import com.example.iot_manager.data.ModelDo;
import com.example.iot_manager.service.ModelService;
import com.example.iot_manager.vo.ModelVO;
import com.example.iot_manager.vo.ResponseVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ModelServiceImpl implements ModelService {

  final
  ModelRepository modelRepository;

  @Autowired
  public ModelServiceImpl(ModelRepository modelRepository) {
    this.modelRepository = modelRepository;
  }

  @Transactional
  public ResponseVO<String> addModel(ModelVO modelVO) {
    try{
      ModelDo modelDo=new ModelDo();
      modelDo.setModelVO(modelVO);
      return ResponseVO.buildSuccess("Success");
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Transactional
  public ResponseVO<String> updateModel(int modelId, ModelVO modelVO) {
    try{
      ModelDo modelDo=modelRepository.findByModelId(modelId);
      modelDo.setModelVO(modelVO);
      modelDo.setUpdateTime(new Date());
      return ResponseVO.buildSuccess("Success");
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Transactional
  public ResponseVO<String> deleteModel(int modelId) {
    try{
      modelRepository.deleteByModelId(modelId);
      return ResponseVO.buildSuccess("Success");
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  public ResponseVO<List<ModelDo>> findAllModel(int page, int size) {
    try{
      PageRequest pageRequest=PageRequest.of(page, size);
      List<String> list=new ArrayList<>();
      CollectionUtils.arrayToList();
      return ResponseVO.buildSuccess(modelRepository.findAll(pageRequest).getContent());
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  public ResponseVO<ModelDo> findModel(int modelId) {
    try{
      return ResponseVO.buildSuccess(modelRepository.findByModelId(modelId));
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }
}
