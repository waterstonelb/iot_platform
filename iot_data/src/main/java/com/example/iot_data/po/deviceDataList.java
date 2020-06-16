package com.example.iot_data.po;

import java.util.List;
import lombok.ToString;

@ToString
public class deviceDataList {
    private List<DataTransVO> list;

    public List<DataTransVO> getList() {
        return list;
    }

    public void setList(List<DataTransVO> list) {
        this.list = list;
    }
}
