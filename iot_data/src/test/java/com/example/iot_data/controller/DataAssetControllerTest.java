package com.example.iot_data.controller;

import com.example.iot_data.service.DataAssetInter;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class DataAssetControllerTest {

    @Test
    void getDataByName() throws Exception {
        DataAssetInter dataAssetInter=mock(DataAssetInter.class);
        DataAssetController dataAssetController=new DataAssetController(dataAssetInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(dataAssetController).build();
        mockMvc.perform(post("/getData")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content("\"testdevice\""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        verify(dataAssetInter).getData("testdevice");
    }

    @Test
    void getData() throws Exception {
        DataAssetInter dataAssetInter=mock(DataAssetInter.class);
        DataAssetController dataAssetController=new DataAssetController(dataAssetInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(dataAssetController).build();
        mockMvc.perform(post("/getDeviceList")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        verify(dataAssetInter).getDevice();
    }

    @Test
    void toIndex() throws Exception {
        DataAssetInter dataAssetInter=mock(DataAssetInter.class);
        DataAssetController dataAssetController=new DataAssetController(dataAssetInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(dataAssetController).build();
        mockMvc.perform(post("/")).andExpect(view().name("dataSource.html"));
    }

    @Test
    void toAsset() throws Exception {
        DataAssetInter dataAssetInter=mock(DataAssetInter.class);
        DataAssetController dataAssetController=new DataAssetController(dataAssetInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(dataAssetController).build();
        mockMvc.perform(post("/dataAsset")).andExpect(view().name("dataAsset.html"));
    }

    @Test
    void toAnalyze() throws Exception {
        DataAssetInter dataAssetInter=mock(DataAssetInter.class);
        DataAssetController dataAssetController=new DataAssetController(dataAssetInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(dataAssetController).build();
        mockMvc.perform(post("/analyze")).andExpect(view().name("analyze.html"));
    }

    @Test
    void toDataSource() throws Exception {
        DataAssetInter dataAssetInter=mock(DataAssetInter.class);
        DataAssetController dataAssetController=new DataAssetController(dataAssetInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(dataAssetController).build();
        mockMvc.perform(post("/dataSource")).andExpect(view().name("dataSource.html"));
    }

    @Test
    void toSpace() throws Exception {
        DataAssetInter dataAssetInter=mock(DataAssetInter.class);
        DataAssetController dataAssetController=new DataAssetController(dataAssetInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(dataAssetController).build();
        mockMvc.perform(post("/space")).andExpect(view().name("space.html"));
    }
}