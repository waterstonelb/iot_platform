package com.example.iot_driver.data;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ModelMapper {

    int getModelIdByAttr(String attrName);
}
