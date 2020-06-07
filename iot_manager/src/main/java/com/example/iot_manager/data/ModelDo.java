package com.example.iot_manager.data;

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

    private Date createTime;

    private Date updateTime;
}
