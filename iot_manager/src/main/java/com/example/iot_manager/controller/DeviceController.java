package com.example.iot_manager.controller;

import com.example.iot_manager.data.DeviceDo;
import com.example.iot_manager.service.DeviceService;
import com.example.iot_manager.vo.DeviceVO;
import com.example.iot_manager.vo.ResponseVO;
import com.example.iot_manager.vo.StatusVO;
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
@RequestMapping("/device")
public class DeviceController {

  protected final DeviceService deviceService;

  @Autowired
  public DeviceController(DeviceService deviceService) {
    this.deviceService = deviceService;
  }


  @GetMapping("/get")
  public ResponseVO<DeviceDo> getDevice(int deviceId) {
    return deviceService.getDeviceById(deviceId);
  }

  @GetMapping("/getall")
  public ResponseVO<List<DeviceDo>> getAllDevice(int page, int size) {
    return deviceService.getAllDevice(page, size);
  }

  @GetMapping("/getbyname")
  public ResponseVO<List<DeviceDo>> getDeviceByName(String name, int page, int size) {
    return deviceService.getDeviceByNameLike(name, page, size);
  }

  @PostMapping("/add")
  public ResponseVO<String> addDevice(@RequestBody DeviceVO deviceVO) {
    return deviceService.addDevice(deviceVO);
  }

  @DeleteMapping("/delete")
  public ResponseVO<String> deleteDevice(int deviceId) {
    return deviceService.deleteDevice(deviceId);
  }

  @GetMapping("/updategroup")
  public ResponseVO<String> updateGroup(int groupId, int deviceId){
    return deviceService.updateGroup(groupId, deviceId);
  }

  @PostMapping("/updatestatus")
  public ResponseVO<String> updateStatus(@RequestBody StatusVO statusVO) {
    System.out.println(statusVO.getDeviceId());
    return deviceService.updateStatus(statusVO.getStatus(), statusVO.getDeviceId());
  }

  @PostMapping("/update")
  public ResponseVO<String> updateDevice(@RequestParam int deviceId,
      @RequestBody DeviceVO deviceVO) {
    return deviceService.updateDevice(deviceId, deviceVO);
  }

  @PostMapping("updateonline")
  public ResponseVO<String> updateOnline(@RequestBody StatusVO statusVO) {
    return deviceService.updateOnline(statusVO.getStatus(), statusVO.getDeviceId());
  }


}
