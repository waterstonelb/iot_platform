package com.example.iot_manager.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.example.iot_manager.vo.DeviceVO;
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

  private int groupId = -1;

  private String deviceName;

  private int deviceStatus = 0;

  private int isOnline = 0;

  private String protocol;

  private String ipAddress;

  private String deviceDescription;

  @Column(name = "create_time", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private Date createTime;

  @Column(name = "update_time", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
  private Date updateTime;

  private Date onlineTime;

  public void setDeviceVO(DeviceVO deviceVO) {
    this.deviceName = deviceVO.getDeviceName();
    this.deviceDescription = deviceVO.getDeviceDescription();
    this.protocol = deviceVO.getProtocol();
    this.ipAddress = deviceVO.getIpAddress();
    this.groupId = deviceVO.getGroupId();
  }

}
