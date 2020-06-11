package com.example.iot_data.controller;

import com.example.iot_data.po.deviceData;
import com.example.iot_data.service.DataAssetInter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@MapperScan("com.example.iot_data.dao")
@ComponentScan(basePackages = {"com.example.iot_data.serviceImpl","com.example.iot_data.dao"})
public class DataAssetController {
    @Autowired
    private DataAssetInter dataAssetInter;

    @RequestMapping(value={"/getData"},method= RequestMethod.POST)
    @ResponseBody
    public List<deviceData> getData(@RequestBody String name){
        return dataAssetInter.getData(name.substring(1,name.length()-1));
    }

    @RequestMapping(value={"/getDeviceList"},method= RequestMethod.POST)
    @ResponseBody
    public List<deviceData> getData(){
        return dataAssetInter.getDevice();
    }

    @GetMapping
    public String toIndex(){
        return "dataAsset.html";
    }

    @RequestMapping("/dataAsset")
    public String toAsset(){return "dataAsset.html";}

    @RequestMapping("/analyze")
    public String toAnalyze(){return "analyze.html";}

    @RequestMapping("/dataSource")
    public String toDataSource(){return "dataSource.html";}

    @RequestMapping("/space")
    public String toSpace(){return "space.html";}
}
