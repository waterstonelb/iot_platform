package com.example.iot_manager.service.serviceimpl;

import com.example.iot_manager.client.DriverServiceClient;
import com.example.iot_manager.dao.DeviceModelRepository;
import com.example.iot_manager.dao.DeviceRepository;
import com.example.iot_manager.data.DeviceDo;
import com.example.iot_manager.data.DeviceModelDo;
import com.example.iot_manager.service.DeviceService;
import com.example.iot_manager.service.ShadowService;
import com.example.iot_manager.vo.*;

import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DeviceServiceImpl implements DeviceService {

  final DeviceRepository deviceRepository;
  final ShadowService shadowService;
  final DriverServiceClient driverServiceClient;
  final DeviceModelRepository deviceModelRepository;

  @Autowired
  public DeviceServiceImpl(DeviceRepository deviceRepository, ShadowService shadowService,
      DriverServiceClient driverServiceClient, DeviceModelRepository deviceModelRepository) {
    this.deviceRepository = deviceRepository;
    this.shadowService = shadowService;
    this.driverServiceClient = driverServiceClient;
    this.deviceModelRepository = deviceModelRepository;
  }


  @Override
  @Transactional
  public ResponseVO<String> addDevice(DeviceVO deviceVO) {
    try {
      DeviceDo deviceDo = new DeviceDo();
      deviceDo.setDeviceVO(deviceVO);
      DeviceDo resDo = deviceRepository.save(deviceDo);
      int deviceId = resDo.getDeviceId();
      /*
      生成初始影子信息
       */
      shadowService.addShadow(ShadowVO.builder()
          .deviceId(deviceId)
          .metaData("初始化设备")
          .report("初始化传输信息")
          .build());
      /*
      hook到连接管理，激活设备
       */
      SimpleDeviceVO simpleDeviceVO = new SimpleDeviceVO();
      BeanUtils.copyProperties(resDo, simpleDeviceVO);
      log.info(simpleDeviceVO.toString());
      //driverServiceClient.addDevice(simpleDeviceVO);

      /*
      加入模型信息
       */
      deviceVO.getModelIds()
          .forEach(t -> deviceModelRepository.save(new DeviceModelDo(deviceId, t)));

      return ResponseVO.buildSuccess("add success");
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Override
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

  @Override
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

  @Override
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

  @Override
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

  @Override
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

  @Override
  public ResponseVO<PageResult<DeviceDo>> getAllDevice(int page, int size) {
    try {
      PageRequest pageRequest = PageRequest.of(page, size);
      Page<DeviceDo> deviceDoList = deviceRepository.findAllDevice(pageRequest);
      return ResponseVO.buildSuccess(
          PageResult.createPageResult(deviceDoList.getContent(), deviceDoList.getTotalElements()));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Override
  public ResponseVO<DeviceDo> getDeviceById(int deviceId) {
    try {
      DeviceDo deviceDo = deviceRepository.findByDeviceId(deviceId);
      return ResponseVO.buildSuccess(deviceDo);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Override
  public ResponseVO<PageResult<DeviceDo>> getDeviceByNameLike(String deviceName, int page,
      int size) {
    try {
      PageRequest pageRequest = PageRequest.of(page, size);
      Page<DeviceDo> deviceDoPage = deviceRepository
          .findByDeviceNameLike("%" + deviceName + "%", pageRequest);
      return ResponseVO.buildSuccess(
          PageResult.createPageResult(deviceDoPage.getContent(), deviceDoPage.getTotalElements()));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Override
  public ResponseVO<PageResult<DeviceGroupVO>> getDeviceInGroup(int groupId, int page, int size) {
    try {
      PageRequest pageRequest = PageRequest.of(page, size);
      Page<DeviceDo> list = deviceRepository.findByGroupId(groupId, pageRequest);
      List<DeviceGroupVO> deviceGroupVOS = list.stream().map(DeviceDo::transfor)
          .collect(Collectors.toList());
      return ResponseVO.buildSuccess(
          PageResult.createPageResult(deviceGroupVOS,list.getTotalElements()));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }
}
