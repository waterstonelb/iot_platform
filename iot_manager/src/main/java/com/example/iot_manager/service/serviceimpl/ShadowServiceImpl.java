package com.example.iot_manager.service.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.example.iot_manager.dao.ShadowRepository;
import com.example.iot_manager.data.ShadowDo;
import com.example.iot_manager.service.ShadowService;
import com.example.iot_manager.vo.ResponseVO;
import com.example.iot_manager.vo.ShadowVO;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShadowServiceImpl implements ShadowService {

  final
  ShadowRepository shadowRepository;

  @Autowired
  public ShadowServiceImpl(ShadowRepository shadowRepository) {
    this.shadowRepository = shadowRepository;
  }

  @Override
  public void addShadow(ShadowVO shadowVO) {
    try {
      shadowRepository.save(new ShadowDo(shadowVO));
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  @Override
  @Transactional
  public ResponseVO<String> updateShadow(int shadowId) {
    try{
      ShadowDo shadowDo=shadowRepository.findByShadowId(shadowId);
      shadowDo.updateVersion();
      shadowRepository.save(shadowDo);
      return ResponseVO.buildSuccess("Success");
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Override
  public ResponseVO<String> getShadowByDevice(int deviceId) {
    try{
      ShadowDo shadowDo=shadowRepository.findByDeviceId(deviceId);
      String shadowJSON= JSON.toJSONString(shadowDo);
      System.out.println(shadowJSON);
      return ResponseVO.buildSuccess(shadowJSON);
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Override
  @Transactional
  public ResponseVO<String> deleteShadow(int shadowId) {
    try{
      shadowRepository.deleteByShadowId(shadowId);
      return ResponseVO.buildSuccess("Success");
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }
}
