package com.example.iot_manager.controller;

import com.example.iot_manager.data.DeviceDo;
import com.example.iot_manager.service.DeviceService;
import com.example.iot_manager.vo.DeviceVO;
import com.example.iot_manager.vo.ResponseVO;
import com.example.iot_manager.vo.StatusVO;
import io.swagger.annotations.ApiOperation;
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


  @ApiOperation("根据deviceId获取设备详情")
  @GetMapping("/get")
  public ResponseVO<DeviceDo> getDevice(int deviceId) {
    return deviceService.getDeviceById(deviceId);
  }

  @ApiOperation("获取全部设备信息（分页）")
  @GetMapping("/getall")
  public ResponseVO<List<DeviceDo>> getAllDevice(int page, int size) {
    return deviceService.getAllDevice(page, size);
  }

  @ApiOperation("模糊deviceName查询设备（分页）")
  @GetMapping("/getbyname")
  public ResponseVO<List<DeviceDo>> getDeviceByName(String name, int page, int size) {
    return deviceService.getDeviceByNameLike(name, page, size);
  }

  @ApiOperation("添加设备")
  @PostMapping("/add")
  public ResponseVO<String> addDevice(@RequestBody DeviceVO deviceVO) {
    return deviceService.addDevice(deviceVO);
  }

  @ApiOperation("删除设备")
  @DeleteMapping("/delete")
  public ResponseVO<String> deleteDevice(int deviceId) {
    return deviceService.deleteDevice(deviceId);
  }

  @ApiOperation("更新设备所属组（删除组的话组号为0）")
  @GetMapping("/updategroup")
  public ResponseVO<String> updateGroup(int groupId, int deviceId){
    return deviceService.updateGroup(groupId, deviceId);
  }

  @ApiOperation("更新设备状态")
  @PostMapping("/updatestatus")
  public ResponseVO<String> updateStatus(@RequestBody StatusVO statusVO) {
    System.out.println(statusVO.getDeviceId());
    return deviceService.updateStatus(statusVO.getStatus(), statusVO.getDeviceId());
  }

  @ApiOperation("更新设备")
  @PostMapping("/update")
  public ResponseVO<String> updateDevice(@RequestParam int deviceId,
      @RequestBody DeviceVO deviceVO) {
    return deviceService.updateDevice(deviceId, deviceVO);
  }

  @ApiOperation("更新设备是否在线")
  @PostMapping("updateonline")
  public ResponseVO<String> updateOnline(@RequestBody StatusVO statusVO) {
    return deviceService.updateOnline(statusVO.getStatus(), statusVO.getDeviceId());
  }


}
