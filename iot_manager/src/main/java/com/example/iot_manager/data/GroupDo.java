package com.example.iot_manager.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "manager_group")
public class GroupDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;

    private int parentId;

    private String groupDescription;

    private String groupName;

    @Column(name = "create_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;

    @Column(name = "update_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;
}
