package com.example.iot_data.dao;

import com.example.iot_data.po.deviceData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DataSourceMapper {
    void addDeviceData(int id,String name,double temperature,double press,String time,String ip);
    void delete(String name);
    List<deviceData> getDeviceData(int id,String name,String time,String ip);
}
