package com.example.iot_driver.controller;

import com.example.iot_driver.service.DriverService;
import com.example.iot_driver.vo.ResponseVO;
import com.example.iot_driver.vo.SimpleDeviceVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api
public class DriverController {

    @Autowired
    private DriverService driverService;

//    /** 配置设备连接相关信息
//     * {
//     *     deviceId: "String",
//     *     upMegType:[数值型、开关型、地理位置型和文本型4种],
//     *     qos: int, 0,1,2三选一
//     *     protocol: mqtt，
//     *
//     * }
//     * */
//    @RequestMapping(value = "/addConnectInfo", method = RequestMethod.POST)
//    public ResponseVO addConnect(@RequestBody DeviceConnectInfo deviceConnectInfo){
//        return driverService.addConnect(deviceConnectInfo);
//    }
//
//    /** 修改设备连接相关信息*/
//    @RequestMapping(value = "/modifyConnectInfo", method = RequestMethod.POST)
//    public ResponseVO modifyConnectInfo(@RequestBody DeviceConnectInfo deviceConnectInfo){
//        return driverService.modifyConnectInfo(deviceConnectInfo);
//    }
//
//    /** 获取设备连接相关信息*/
//    @RequestMapping(value = "/getConnectInfo/{deviceId}", method = RequestMethod.GET)
//    public ResponseVO getConnectInfo(@PathVariable("deviceId") String deviceId){
//        return driverService.getConnectInfo(deviceId);
//    }

//    /** 设备上线*/
//    @RequestMapping(value = "/{deviceId}/online",method = RequestMethod.GET)
//    public ResponseVO deviceOnline(@PathVariable("deviceId") String deviceId){
//        System.out.println(deviceId);
//        return driverService.deviceOnline(deviceId);
//    }
//
//    /** 设备下线*/
//    @RequestMapping(value = "/{deviceId}/offline", method = RequestMethod.GET)
//    public ResponseVO deviceOffline(@PathVariable("deviceId") String deviceId){
//        return driverService.deviceOffline(deviceId);
//    }

//    /** 向设备下发指令*/
//    @RequestMapping(value = "/sendMsgTo/{deviceId}",method = RequestMethod.POST)
//    public ResponseVO sendMessageToDevice(@PathVariable("deviceId") String deviceId,
//                                          @RequestBody Map<String,String> message){
//        System.out.println(message);
//        return driverService.sendMessageToDevice(deviceId, message.get("message"));
//    }

    @ApiOperation("新增设备时调用  为设备绑定系统默认主题")
    @PostMapping("/addDevice")
    public ResponseVO addDevice(@RequestBody SimpleDeviceVO deviceVO){
        return driverService.addDevice(deviceVO);
    }

    /**
     * 激活设备
     * 平台订阅设备所有订阅请求
     */
    @ApiOperation(value = "激活设备或设备上线，平台订阅设备的所有订阅主题", notes = "暴露给设备管理的接口 设备激活时调用")
    @RequestMapping(value = "/activateDevice/{deviceId}", method = RequestMethod.GET)
    public ResponseVO activateDevice(@PathVariable("deviceId") int deviceId){
        System.out.println(deviceId);
        return driverService.activateDevice(deviceId);
    }

    /**
     * 禁用设备
     * 平台取消对所有设备的订阅请求
     * @return
     */
    @ApiOperation("禁用设备或设备下线调用  取消平台对设备的所有订阅请求")
    @GetMapping("/disableDevice/{deviceId}")
    public ResponseVO disable(@PathVariable("deviceId") int deviceId){
        return driverService.disable(deviceId);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return 5 +" hello world";
    }
}
