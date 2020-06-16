package com.example.iot_manager.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataTransVO {

  private Integer id;

  private List<SimpleModelVO> modelVOS;

  private String name;

  private Date time;

  private String ip;

}
