package com.example.iot_manager.data;

import com.example.iot_manager.vo.ShadowVO;
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
@Table(name = "manager_shadow")
public class ShadowDo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shadowId;

    private int deviceId;

    private String metaData;

    private String report;

    private int version;

    @Column(name = "create_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;
    @Column(name = "update_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;

    private Date repTime;

    public void updateVersion(){
        this.version++;
    }

    public ShadowDo(ShadowVO shadowVO){
        this.deviceId=shadowVO.getDeviceId();
        this.metaData=shadowVO.getMetaData();
        this.report=shadowVO.getReport();
        this.version=1;
        this.repTime=new Date();
    }

}
