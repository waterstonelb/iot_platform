package com.example.iot_manager.service;

import com.example.iot_manager.data.ModelDo;
import com.example.iot_manager.vo.ModelVO;
import com.example.iot_manager.vo.PageResult;
import com.example.iot_manager.vo.ResponseVO;
import java.util.List;

public interface ModelService {

  ResponseVO<String> addModel(ModelVO modelVO);

  ResponseVO<String> updateModel(int modelId, ModelVO modelVO);

  ResponseVO<String> deleteModel(int modelId);

  ResponseVO<PageResult<ModelDo>> findAllModel(int page, int size);

  ResponseVO<ModelDo> findModel(int modelId);
}
