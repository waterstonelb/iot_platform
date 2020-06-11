package com.example.iot_manager.data;

import com.example.iot_manager.vo.GroupVO;
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

  private int parentId = 0;

  private String groupDescription;

  private String groupName;

  @Column(name = "create_time", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private Date createTime;

  @Column(name = "update_time", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
  private Date updateTime;

  public void setGroupVO(GroupVO groupVO) {
    this.groupName = groupVO.getGroupName();
    this.groupDescription = groupVO.getGroupDescription();
    this.parentId = groupVO.getParentId();
  }
}
