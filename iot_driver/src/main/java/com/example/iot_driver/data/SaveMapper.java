package com.example.iot_driver.data;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SaveMapper {

    int saveMessage(@Param("deviceId") String deviceId,
                    @Param("type") String type,
                    @Param("context") String context);
}
