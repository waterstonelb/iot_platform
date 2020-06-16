package com.example.iot_data.controller;

import com.alibaba.fastjson.JSON;
import com.example.iot_data.service.AnalyzeInter;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

class AnalyzeControllerTest {

    @Test
    void getDataByTime() throws Exception {
        AnalyzeInter analyzeInter=mock(AnalyzeInter.class);
        AnalyzeController analyzeController=new AnalyzeController(analyzeInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(analyzeController).build();

        Map<String,String> map=new HashMap<String, String>();
        map.put("名称","testdevice");
        map.put("时间1","2020-05-22 00:00:00");
        map.put("时间2","2020-06-01 00:00:00");

        mockMvc.perform(post("/timeAnalyze")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(JSON.toJSONString(map)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        verify(analyzeInter).getDataByTime("testdevice","2020-05-22 00:00:00","2020-06-01 00:00:00");
    }

    @Test
    void visualization() throws Exception {
        AnalyzeInter analyzeInter=mock(AnalyzeInter.class);
        AnalyzeController analyzeController=new AnalyzeController(analyzeInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(analyzeController).build();
        mockMvc.perform(post("/visual")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content("\"testdevice\""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(analyzeInter).getDeviceData("testdevice");
    }

    @Test
    void visualizationByCondition() throws Exception {
        AnalyzeInter analyzeInter=mock(AnalyzeInter.class);
        AnalyzeController analyzeController=new AnalyzeController(analyzeInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(analyzeController).build();

        Map<String,String> map=new HashMap<String, String>();
        map.put("名称","testdevice");
        map.put("时间1","2020-05-22 00:00:00");
        map.put("时间2","2020-06-01 00:00:00");
        map.put("温度1","2.3");
        map.put("温度2","54");
        map.put("压力1","2");
        map.put("压力2","400");
        map.put("属性","time");
        map.put("顺序","1");

        mockMvc.perform(post("/visualByCondition")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(JSON.toJSONString(map)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        verify(analyzeInter).getDeviceDataByCondition("testdevice",2.3,54,2,400,"2020-05-22 00:00:00","2020-06-01 00:00:00","time",1);
    }

    @Test
    void sqlAnalyze() throws Exception {
        AnalyzeInter analyzeInter=mock(AnalyzeInter.class);
        AnalyzeController analyzeController=new AnalyzeController(analyzeInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(analyzeController).build();
        mockMvc.perform(post("/sql")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content("\"select * from device;\""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(analyzeInter).sqlAnalyze("select * from device;");
    }
}