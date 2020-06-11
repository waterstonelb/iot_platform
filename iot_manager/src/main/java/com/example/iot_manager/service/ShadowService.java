package com.example.iot_manager.service;

import com.example.iot_manager.vo.ResponseVO;
import com.example.iot_manager.vo.ShadowVO;

public interface ShadowService {

  void addShadow(ShadowVO shadowVO);

  ResponseVO<String> updateShadow(int shadowId);

  ResponseVO<String> getShadowByDevice(int deviceId);

  ResponseVO<String> deleteShadow(int shadowId);
}
