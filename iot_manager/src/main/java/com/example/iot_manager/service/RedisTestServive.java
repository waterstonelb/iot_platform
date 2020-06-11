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



}
