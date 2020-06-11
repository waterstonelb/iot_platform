package com.example.iot_data.serviceImpl;

import com.example.iot_data.dao.AnalyzeMapper;
import com.example.iot_data.po.deviceData;
import com.example.iot_data.service.AnalyzeInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyzeImpl implements AnalyzeInter {

    @Autowired
    private AnalyzeMapper analyzeMapper;

    @Override
    public List<deviceData> getDataByTime(String name,String time1,String time2){
        return analyzeMapper.getDataByTime(name,time1,time2);
    }

    @Override
    public List<deviceData> getDeviceData(String name){
        return analyzeMapper.getDeviceData(name);
    }

    @Override
    public List<deviceData> getDeviceDataByCondition(String name,double temperature1,double temperature2,double press1,double press2,String time1,String time2,String attr,int p) {
        if(attr.equals("time")){
            if(p==1)
                return analyzeMapper.getDeviceDataByTime1(name,temperature1,temperature2,press1,press2,time1,time2);
            else
                return analyzeMapper.getDeviceDataByTime2(name,temperature1,temperature2,press1,press2,time1,time2);
        }
        else if(attr.equals("temp")){
            if(p==1)
                return analyzeMapper.getDeviceDataByTemp1(name,temperature1,temperature2,press1,press2,time1,time2);
            else
                return analyzeMapper.getDeviceDataByTemp2(name,temperature1,temperature2,press1,press2,time1,time2);
        }
        else{
            if(p==1)
                return analyzeMapper.getDeviceDataByPress1(name,temperature1,temperature2,press1,press2,time1,time2);
            else
                return analyzeMapper.getDeviceDataByPress2(name,temperature1,temperature2,press1,press2,time1,time2);
        }
    }
}
