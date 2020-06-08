package com.example.iot_manager.service.serviceimpl;

import com.example.iot_manager.dao.DeviceRepository;
import com.example.iot_manager.data.DeviceDo;
import com.example.iot_manager.service.DeviceService;
import com.example.iot_manager.service.ShadowService;
import com.example.iot_manager.vo.DeviceVO;
import com.example.iot_manager.vo.ResponseVO;
import com.example.iot_manager.vo.ShadowVO;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

  final DeviceRepository deviceRepository;
  final ShadowService shadowService;

  @Autowired
  public DeviceServiceImpl(DeviceRepository deviceRepository, ShadowService shadowService) {
    this.deviceRepository = deviceRepository;
    this.shadowService = shadowService;
  }


  @Transactional
  public ResponseVO<String> addDevice(DeviceVO deviceVO) {
    try {
      DeviceDo deviceDo = new DeviceDo();
      deviceDo.setDeviceVO(deviceVO);
      DeviceDo resDo=deviceRepository.save(deviceDo);
      int deviceId=resDo.getDeviceId();
      shadowService.addShadow(ShadowVO.builder()
          .deviceId(deviceId)
          .metaData("初始化设备")
          .report("初始化传输信息")
          .build());
      return ResponseVO.buildSuccess("add success");
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Transactional
  public ResponseVO<String> updateGroup(int groupId, int deviceId) {
    try {
      deviceRepository.updateGroup(groupId, deviceId);
      return ResponseVO.buildSuccess("Success");
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Transactional
  public ResponseVO<String> deleteDevice(int deviceId) {
    try {
      deviceRepository.deleteByDeviceId(deviceId);
      return ResponseVO.buildSuccess("delete success");
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Transactional
  public ResponseVO<String> updateDevice(int deviceId, DeviceVO deviceVO) {
    try {
      DeviceDo deviceDo = deviceRepository.findByDeviceId(deviceId);
      deviceDo.setDeviceVO(deviceVO);
      deviceRepository.save(deviceDo);
      return ResponseVO.buildSuccess("update success");
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Transactional
  public ResponseVO<String> updateStatus(int status, int deviceId) {
    try {
      deviceRepository.updateDeviceStatus(status, deviceId);
      return ResponseVO.buildSuccess("update success");
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Transactional
  public ResponseVO<String> updateOnline(int isOnline, int deviceId) {
    try {
      deviceRepository.updateIsOnline(isOnline, deviceId, new Date());
      return ResponseVO.buildSuccess("update success");
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  public ResponseVO<List<DeviceDo>> getAllDevice(int page, int size) {
    try {
      PageRequest pageRequest = PageRequest.of(page, size);
      List<DeviceDo> deviceDoList = deviceRepository.findAllDevice(pageRequest).getContent();
      return ResponseVO.buildSuccess(deviceDoList);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  public ResponseVO<DeviceDo> getDeviceById(int deviceId) {
    try {
      DeviceDo deviceDo = deviceRepository.findByDeviceId(deviceId);
      return ResponseVO.buildSuccess(deviceDo);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  public ResponseVO<List<DeviceDo>> getDeviceByNameLike(String deviceName, int page, int size) {
    try {
      PageRequest pageRequest = PageRequest.of(page, size);
      List<DeviceDo> deviceDoList = deviceRepository
          .findByDeviceNameLike("%" + deviceName + "%", pageRequest).getContent();
      return ResponseVO.buildSuccess(deviceDoList);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }
}
