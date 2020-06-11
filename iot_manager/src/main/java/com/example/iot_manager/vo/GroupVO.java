package com.example.iot_manager.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupVO {

  private int parentId;

  private String groupDescription;

  private String groupName;
}
