package com.example.iot_manager.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "manager_device")
public class DeviceDo implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
