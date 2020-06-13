package com.example.iot_data.controller;

import com.example.iot_data.service.SpaceVisualInter;
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

class SpaceVisualControllerTest {

    @Test
    void getPoint() throws Exception {
        SpaceVisualInter spaceVisualInter=mock(SpaceVisualInter.class);
        SpaceVisualController spaceVisualController=new SpaceVisualController(spaceVisualInter);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spaceVisualController).build();
        mockMvc.perform(post("/getPoint")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(spaceVisualInter).getPoint();
    }
}