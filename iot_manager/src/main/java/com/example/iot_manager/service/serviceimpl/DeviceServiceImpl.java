package com.example.iot_manager.service.serviceimpl;

import com.example.iot_manager.dao.DeviceRepository;
import com.example.iot_manager.data.DeviceDo;
import com.example.iot_manager.service.DeviceService;
import com.example.iot_manager.vo.DeviceVO;
import com.example.iot_manager.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    final DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public ResponseVO<String> addDevice(DeviceVO deviceVO) {
        try {
            deviceRepository.save(new DeviceDo(deviceVO));
            return ResponseVO.buildSuccess("add success");
        }catch (Exception e){
            return ResponseVO.buildFailure("add fail");
        }
    }

    public ResponseVO<String> deleteDevice(int deviceId) {
        try {
            deviceRepository.deleteByDeviceId(deviceId);
            return ResponseVO.buildSuccess("delete success");
        }catch (Exception e){
            return ResponseVO.buildFailure("delete fail");
        }
    }

    public ResponseVO<String> updateDevice(DeviceDo deviceDo) {
        try {
            deviceRepository.save(deviceDo);
            return ResponseVO.buildSuccess("update success");
        }catch (Exception e){
            return ResponseVO.buildFailure("update fail");
        }
    }

    public ResponseVO<String> updateStatus(int status, int deviceId) {
        try {
            deviceRepository.updateDeviceStatus(status,deviceId);
            return ResponseVO.buildSuccess("update success");
        }catch (Exception e){
            return ResponseVO.buildFailure("update fail");
        }
    }

    public ResponseVO<String> updateOnline(int isOnline, int deviceId) {
        try {
            deviceRepository.updateIsOnline(isOnline,deviceId,new Date());
            return ResponseVO.buildSuccess("update success");
        }catch (Exception e){
            return ResponseVO.buildFailure("update fail");
        }
    }

    public ResponseVO<List<DeviceDo>> getAllDevice(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size);
            List<DeviceDo> deviceDoList = deviceRepository.findAll(pageRequest).getContent();
            return ResponseVO.buildSuccess(deviceDoList);
        }catch (Exception e){
            return ResponseVO.buildFailure("get fail");
        }
    }

    public ResponseVO<DeviceDo> getDeviceById(int deviceId) {
        try {
            DeviceDo deviceDo=deviceRepository.findByDeviceId(deviceId);
            return ResponseVO.buildSuccess(deviceDo);
        }catch (Exception e){
            return ResponseVO.buildFailure("get fail");
        }
    }

    public ResponseVO<List<DeviceDo>> getDeviceByNameLike(String deviceName, int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size);
            List<DeviceDo> deviceDoList=deviceRepository.findByDeviceNameLike(deviceName,pageRequest).getContent();
            return ResponseVO.buildSuccess(deviceDoList);
        }catch (Exception e){
            return ResponseVO.buildFailure("get fail");
        }
    }
}
