package com.example.iot_manager.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelVO {
  private String modelName;

  private String attrName;

  private String attrIdentifier;

  private String dataType;

  private int dataLen;

  private String dataUnit;

  private int dataMin;

  private int dataMax;

  private String modelDescription;

  private String serviceName;

  private String serviceIdentifier;

  private int callMethod;

  private String serviceDescription;
}
