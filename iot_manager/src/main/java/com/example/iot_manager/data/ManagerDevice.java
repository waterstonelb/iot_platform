package com.example.iot_manager.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ManagerDevice implements Serializable {

  @Id
  private int deviceId;
  private int modelId;
  private int groupId;
  private String deviceName;
  private int deviceStatus;
  private String protocol;
  private String deviceDescription;
  private Date createTime;
  private Date updateTime;
  private Date onlineTime;

}
