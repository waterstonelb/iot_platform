package com.example.iot_manager.controller;

import com.example.iot_manager.data.DeviceDo;
import com.example.iot_manager.service.DeviceService;
import com.example.iot_manager.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseVO<DeviceDo> getDevice(int deviceId){
        return null;
    }

}
