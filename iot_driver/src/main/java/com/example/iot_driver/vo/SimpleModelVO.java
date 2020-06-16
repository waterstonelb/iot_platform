package com.example.iot_driver.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleModelVO {

  private int modelId;

  @JsonIgnoreProperties
  private String name;

  private int num;



}
