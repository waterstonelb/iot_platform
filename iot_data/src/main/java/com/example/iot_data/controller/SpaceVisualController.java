package com.example.iot_data.controller;

import com.example.iot_data.po.point;
import com.example.iot_data.service.SpaceVisualInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpaceVisualController {
    @Autowired
    private SpaceVisualInter spaceVisualInter;

    public SpaceVisualController(SpaceVisualInter spaceVisualInter){
        this.spaceVisualInter=spaceVisualInter;
    }

    @RequestMapping(value={"/getPoint"},method= RequestMethod.POST)
    @ResponseBody
    public List<point> getPoint(){
        return spaceVisualInter.getPoint();
    }
}
