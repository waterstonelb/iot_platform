package com.example.iot_driver.data;

import com.example.iot_driver.vo.TopicVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface TopicMapper {

    List<TopicVo> getTopic(int deviceId);

    int addTopic(TopicVo topicVo);

    int deleteTopic(String topicName);

    int modifyDescribe(@Param("topicName") String topicName,
                       @Param("describe") String describe);

    /** 获取设备所有订阅主题*/
    List<Map<String,Object>> getAllSub(int deviceId);

    int getDeviceIdByTopic(String topicName);
}
