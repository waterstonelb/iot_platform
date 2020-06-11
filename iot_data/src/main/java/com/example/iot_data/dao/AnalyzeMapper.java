package com.example.iot_data.dao;

import com.example.iot_data.po.deviceData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AnalyzeMapper {
    List<deviceData> getDataByTime(@Param("name")String name,@Param("time1") String time1,@Param("time2") String time2);
    List<deviceData> getDeviceData(@Param("name")String name);
    List<deviceData> getDeviceDataByTime1(@Param("name") String name,@Param("temp1")double temp1,@Param("temp2") double temp2,@Param("press1")double press1,@Param("press2") double press2,@Param("time1") String time1,@Param("time2") String time2);
    List<deviceData> getDeviceDataByTime2(@Param("name") String name,@Param("temp1")double temp1,@Param("temp2") double temp2,@Param("press1")double press1,@Param("press2") double press2,@Param("time1") String time1,@Param("time2") String time2);
    List<deviceData> getDeviceDataByTemp1(@Param("name") String name,@Param("temp1")double temp1,@Param("temp2") double temp2,@Param("press1")double press1,@Param("press2") double press2,@Param("time1") String time1,@Param("time2") String time2);
    List<deviceData> getDeviceDataByTemp2(@Param("name") String name,@Param("temp1")double temp1,@Param("temp2") double temp2,@Param("press1")double press1,@Param("press2") double press2,@Param("time1") String time1,@Param("time2") String time2);
    List<deviceData> getDeviceDataByPress1(@Param("name") String name,@Param("temp1")double temp1,@Param("temp2") double temp2,@Param("press1")double press1,@Param("press2") double press2,@Param("time1") String time1,@Param("time2") String time2);
    List<deviceData> getDeviceDataByPress2(@Param("name") String name,@Param("temp1")double temp1,@Param("temp2") double temp2,@Param("press1")double press1,@Param("press2") double press2,@Param("time1") String time1,@Param("time2") String time2);
}
