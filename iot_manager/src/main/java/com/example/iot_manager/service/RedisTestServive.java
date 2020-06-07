package com.example.iot_manager.service;

import com.alibaba.fastjson.JSON;
import com.example.iot_manager.data.DeviceDo;
import java.util.Date;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisTestServive {
  @Autowired
  StringRedisTemplate stringRedisTemplate;

  public String set(){
    DeviceDo device=new DeviceDo(
        1,2,3,"iPad",0,"http","mzl的ipad",new Date(),new Date(),new Date());
    stringRedisTemplate.opsForValue().set("123", JSON.toJSONString(device));
    String deviceStr=stringRedisTemplate.opsForValue().get("123");
    return Objects.requireNonNull(JSON.parseObject(deviceStr, DeviceDo.class)).getDeviceName();
  }

}
