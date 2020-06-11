package com.example.iot_manager.data;

import com.example.iot_manager.vo.ModelVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "manager_model")
public class ModelDo implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int modelId;

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

  @Column(name = "create_time", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private Date createTime;

  @Column(name = "update_time", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
  private Date updateTime;

  public void setModelVO(ModelVO modelVO) {
    this.modelName = modelVO.getModelName();
    this.attrName = modelVO.getAttrName();
    this.attrIdentifier = modelVO.getAttrIdentifier();
    this.dataType = modelVO.getDataType();
    this.dataLen = modelVO.getDataLen();
    this.dataMin = modelVO.getDataMin();
    this.dataMax = modelVO.getDataMax();
    this.modelDescription = modelVO.getModelDescription();
    this.serviceName = modelVO.getServiceName();
    this.serviceIdentifier = modelVO.getServiceIdentifier();
    this.callMethod = modelVO.getCallMethod();
    this.serviceDescription = modelVO.getServiceDescription();
  }
}
