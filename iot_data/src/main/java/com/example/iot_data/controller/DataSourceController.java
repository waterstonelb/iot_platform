package com.example.iot_data.controller;

import com.example.iot_data.service.DataSourceInter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
public class DataSourceController {
    @Autowired
    private DataSourceInter dataSourceInter;

    @RequestMapping(value={"/addDeviceData"},method=RequestMethod.POST)
    @ResponseBody
    public int addDeviceData(@RequestBody(required=false) String name){

        return dataSourceInter.addDeviceData(name.substring(1,name.length()-1));
    }

    @RequestMapping(value={"/deleteDeviceData"},method=RequestMethod.POST)
    @ResponseBody
    public void deleteDeviceData(@RequestBody String name){
        dataSourceInter.deleteDeviceData(name.substring(1,name.length()-1));
    }

    @RequestMapping(value = {"/addExternalData"},method = RequestMethod.POST)
    @ResponseBody
    public int addExternalData(@RequestBody(required = false) String filePath){ //处理.xlsx 文件 必须给全文件名路径
        System.out.println(filePath);
        String new1 = filePath;
        File file = new File(new1.substring(1, new1.length() - 1));
        if(!file.exists()){
            return -1;
        }else {
            int result = dataSourceInter.addExternalData(new1.substring(1, new1.length() - 1));
            return result;
        }
    }

}
