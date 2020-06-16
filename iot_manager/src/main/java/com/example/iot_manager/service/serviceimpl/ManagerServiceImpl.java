package com.example.iot_manager.service.serviceimpl;

import com.example.iot_manager.dao.DeviceRepository;
import com.example.iot_manager.dao.ModelRepository;
import com.example.iot_manager.data.DeviceDo;
import com.example.iot_manager.data.ModelDo;
import com.example.iot_manager.service.ManagerService;
import com.example.iot_manager.vo.DataTransVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

  @Autowired
  DeviceRepository deviceRepository;
  @Autowired
  ModelRepository modelRepository;

  @Override
  public DataTransVO setAttr(DataTransVO dataTransVO) {
    /*
    注入device参数
     */
    DeviceDo deviceDo = deviceRepository.findByDeviceId(dataTransVO.getId());
    dataTransVO.setName(deviceDo.getDeviceName());
    dataTransVO.setIp(deviceDo.getIpAddress());
    /*
    注入物模型参数
     */
    dataTransVO.getModelVOs().forEach(m->{
      ModelDo modelDo = modelRepository.findByModelId(m.getModelId());
      m.setName(modelDo.getAttrName());
    });
    return dataTransVO;
  }
}
