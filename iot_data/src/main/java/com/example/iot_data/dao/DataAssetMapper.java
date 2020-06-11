package com.example.iot_data.dao;

import com.example.iot_data.po.deviceData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DataAssetMapper {
    List<deviceData> getData(String name);
    List<deviceData> getDevice();
}
