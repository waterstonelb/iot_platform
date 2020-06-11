package com.example.iot_data.serviceImpl;

import com.example.iot_data.dao.DataAssetMapper;
import com.example.iot_data.po.deviceData;
import com.example.iot_data.service.DataAssetInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;

@Service
public class DataAssetImpl implements DataAssetInter {
    @Autowired
    private DataAssetMapper dataAssetMapper;

    @Override
    public List<deviceData> getData(String name) {
        return dataAssetMapper.getData(name);
    }

    @Override
    public List<deviceData> getDevice() {
        return dataAssetMapper.getDevice();
    }
}
