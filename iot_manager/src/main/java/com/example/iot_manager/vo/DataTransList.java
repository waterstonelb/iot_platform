package com.example.iot_manager.vo;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataTransList {

  private List<DataTransVO> list;

  public DataTransList(DataTransVO dataTransVO){
    this.list = new ArrayList<>();
    this.list.add(dataTransVO);
  }

}
