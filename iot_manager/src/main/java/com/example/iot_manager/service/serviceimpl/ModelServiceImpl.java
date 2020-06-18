package com.example.iot_manager.service.serviceimpl;

import com.example.iot_manager.dao.ModelRepository;
import com.example.iot_manager.data.ModelDo;
import com.example.iot_manager.service.ModelService;
import com.example.iot_manager.vo.ModelVO;
import com.example.iot_manager.vo.PageResult;
import com.example.iot_manager.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class ModelServiceImpl implements ModelService {

  final
  ModelRepository modelRepository;

  @Autowired
  public ModelServiceImpl(ModelRepository modelRepository) {
    this.modelRepository = modelRepository;
  }

  @Override
  @Transactional
  public ResponseVO<String> addModel(ModelVO modelVO) {
    try{
      ModelDo modelDo=new ModelDo();
      modelDo.setModelVO(modelVO);
      modelRepository.save(modelDo);
      return ResponseVO.buildSuccess("Success");
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Override
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

  @Override
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

  @Override
  public ResponseVO<PageResult<ModelDo>> findAllModel(int page, int size) {
    try{
      PageRequest pageRequest=PageRequest.of(page, size);
      Page<ModelDo> p = modelRepository.findAll(pageRequest);
      return ResponseVO.buildSuccess(
          PageResult.createPageResult(p.getContent(),p.getTotalElements())
      );
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Override
  public ResponseVO<ModelDo> findModel(int modelId) {
    try{
      return ResponseVO.buildSuccess(modelRepository.findByModelId(modelId));
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }
}
