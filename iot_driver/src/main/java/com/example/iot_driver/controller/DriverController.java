package com.example.iot_driver.controller;

import com.example.iot_driver.service.DriverService;
import com.example.iot_driver.vo.DeviceConnectInfo;
import com.example.iot_driver.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    /** 配置设备连接相关信息
     * {
     *     deviceId: "String",
     *     upMegType:[数值型、开关型、地理位置型和文本型4种],
     *     qos: int, 0,1,2三选一
     *     protocol: mqtt，
     *
     * }
     * */
    @RequestMapping(value = "/addConnectInfo", method = RequestMethod.POST)
    public ResponseVO addConnect(@RequestBody DeviceConnectInfo deviceConnectInfo){
        return driverService.addConnect(deviceConnectInfo);
    }

    /** 修改设备连接相关信息*/
    @RequestMapping(value = "/modifyConnectInfo", method = RequestMethod.POST)
    public ResponseVO modifyConnectInfo(@RequestBody DeviceConnectInfo deviceConnectInfo){
        return driverService.modifyConnectInfo(deviceConnectInfo);
    }

    /** 获取设备连接相关信息*/
    @RequestMapping(value = "/getConnectInfo/{deviceId}", method = RequestMethod.GET)
    public ResponseVO getConnectInfo(@PathVariable("deviceId") String deviceId){
        return driverService.getConnectInfo(deviceId);
    }

    /** 设备上线*/
    @RequestMapping(value = "/{deviceId}/online",method = RequestMethod.GET)
    public ResponseVO deviceOnline(@PathVariable("deviceId") String deviceId){
        System.out.println(deviceId);
        return driverService.deviceOnline(deviceId);
    }

    /** 设备下线*/
    @RequestMapping(value = "/{deviceId}/offline", method = RequestMethod.GET)
    public ResponseVO deviceOffline(@PathVariable("deviceId") String deviceId){
        return driverService.deviceOffline(deviceId);
    }

    /** 向设备下发指令*/
    @RequestMapping(value = "/sendMsgTo/{deviceId}",method = RequestMethod.POST)
    public ResponseVO sendMessageToDevice(@PathVariable("deviceId") String deviceId,
                                          @RequestBody Map<String,String> message){
        System.out.println(message);
        return driverService.sendMessageToDevice(deviceId, message.get("message"));
    }

    @RequestMapping(value = "/hello/{deviceId}", method = RequestMethod.GET)
    public int hello(@PathVariable("deviceId") String deviceId){
        System.out.println(deviceId);
        return 0;
    }
}
