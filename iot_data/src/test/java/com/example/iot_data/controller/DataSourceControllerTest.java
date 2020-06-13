package com.example.iot_data.controller;

import com.alibaba.fastjson.JSON;
import com.example.iot_data.po.DataTransVO;
import com.example.iot_data.po.SimpleModelVO;
import com.example.iot_data.po.deviceDataList;
import com.example.iot_data.service.DataSourceInter;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

class DataSourceControllerTest {

    /*@Test
    void addDeviceData() throws Exception {
        DataSourceInter dataSourceInter=mock(DataSourceInter.class);
        DataSourceController dataSourceController=new DataSourceController(dataSourceInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(dataSourceController).build();

        deviceDataList data=new deviceDataList();
        DataTransVO dataTransVO=new DataTransVO();
        dataTransVO.setId(1);
        dataTransVO.setName("devicey");
        dataTransVO.setTime(new Date());
        dataTransVO.setIp("114.55.92.12");
        List<SimpleModelVO> simpleModelVOS=new ArrayList<>();
        SimpleModelVO simpleModelVO1=new SimpleModelVO();
        simpleModelVO1.setNum(12.3);
        simpleModelVOS.add(simpleModelVO1);
        SimpleModelVO simpleModelVO2=new SimpleModelVO();
        simpleModelVO2.setNum(23.54);
        simpleModelVOS.add(simpleModelVO2);
        dataTransVO.setModelVOs(simpleModelVOS);
        List<DataTransVO> list=new ArrayList<>();
        list.add(dataTransVO);
        data.setList(list);

        mockMvc.perform(post("/addDeviceData")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(JSON.toJSONString(data)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        verify(dataSourceInter).addDeviceData(data);
    }

     */

    @Test
    void deleteDeviceData() throws Exception {
        DataSourceInter dataSourceInter=mock(DataSourceInter.class);
        DataSourceController dataSourceController=new DataSourceController(dataSourceInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(dataSourceController).build();
        mockMvc.perform(post("/deleteDeviceData")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content("\"devicex\""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        verify(dataSourceInter).deleteDeviceData("devicex");
    }

    @Test
    void addExternalData() throws Exception {
        DataSourceInter dataSourceInter=mock(DataSourceInter.class);
        DataSourceController dataSourceController=new DataSourceController(dataSourceInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(dataSourceController).build();
        mockMvc.perform(post("/addExternalData")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content("\"D:\\external\\devicex.xlsx\""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        verify(dataSourceInter).addExternalData("D:\\external\\devicex.xlsx");
    }
}