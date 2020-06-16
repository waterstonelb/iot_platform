package com.example.iot_driver.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataTransVO {

  private Integer id;

  private List<SimpleModelVO> modelVOs;

  @JsonIgnoreProperties
  private String name;

  @JsonIgnoreProperties
  private Date time;

  @JsonIgnoreProperties
  private String ip;

}
