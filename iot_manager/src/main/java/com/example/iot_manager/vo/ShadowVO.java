package com.example.iot_manager.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShadowVO {

  private int deviceId;

  private String metaData;

  private String report;

}
