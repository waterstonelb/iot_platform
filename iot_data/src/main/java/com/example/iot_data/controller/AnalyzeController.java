package com.example.iot_data.controller;

import com.example.iot_data.po.deviceData;
import com.example.iot_data.service.AnalyzeInter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AnalyzeController {
    @Autowired
    private AnalyzeInter analyzeInter;

    @RequestMapping(value={"/timeAnalyze"},method= RequestMethod.POST)
    @ResponseBody
    public List<deviceData> getDataByTime(@RequestBody Map<String,String> data){
        String name=data.get("名称");
        String time1=data.get("时间1");
        String time2=data.get("时间2");
        return analyzeInter.getDataByTime(name,time1,time2);
    }

    @RequestMapping(value={"/visual"},method= RequestMethod.POST)
    @ResponseBody
    public List<deviceData> visualization(@RequestBody String name){
        return analyzeInter.getDeviceData(name.substring(1,name.length()-1));
    }

    @RequestMapping(value={"/visualByCondition"},method= RequestMethod.POST)
    @ResponseBody
    public List<deviceData> visualizationByCondition(@RequestBody Map<String,String> condition){
        String name=condition.get("名称");
        double temperature1=Double.parseDouble(condition.get("温度1"));
        double temperature2=Double.parseDouble(condition.get("温度2"));
        double press1=Double.parseDouble(condition.get("压力1"));
        double press2=Double.parseDouble(condition.get("压力2"));
        String time1=condition.get("时间1");
        String time2=condition.get("时间2");
        String attr=condition.get("属性");
        int p=Integer.parseInt(condition.get("顺序"));
        return analyzeInter.getDeviceDataByCondition(name,temperature1,temperature2,press1,press2,time1,time2,attr,p);
    }
}
