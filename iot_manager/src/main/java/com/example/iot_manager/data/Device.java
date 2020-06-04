package com.example.iot_manager.data;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device implements Serializable {

  private int id;
  private int modelId;
  private int groupId;
  private String deviceName;
  private String deviceStatus;
  private long surviveTime;
  private Date startTime;
  private Date stopTime;

}
