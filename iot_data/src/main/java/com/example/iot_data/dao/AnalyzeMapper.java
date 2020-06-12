package com.example.iot_data.dao;

import com.example.iot_data.po.deviceData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

@Mapper
@Component
public interface AnalyzeMapper {
    List<deviceData> getDataByTime(String name,String time1,String time2);
    List<deviceData> getDeviceData(String name);
    List<deviceData> getDeviceDataByTime1(String name,double temp1,double temp2,double press1, double press2, String time1, String time2);
    List<deviceData> getDeviceDataByTime2(String name,double temp1,double temp2,double press1, double press2, String time1, String time2);
    List<deviceData> getDeviceDataByTemp1(String name,double temp1,double temp2,double press1,double press2, String time1, String time2);
    List<deviceData> getDeviceDataByTemp2(String name,double temp1,double temp2,double press1,double press2, String time1, String time2);
    List<deviceData> getDeviceDataByPress1(String name,double temp1,double temp2,double press1,double press2, String time1, String time2);
    List<deviceData> getDeviceDataByPress2(String name,double temp1,double temp2,double press1, double press2, String time1,String time2);

    List<deviceData> sqlAnalyze(String sql) throws SQLSyntaxErrorException;
}
