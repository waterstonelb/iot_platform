package com.example.iot_manager.vo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
  private Long totalNum;
  private List<T> result;

  public static <T> PageResult<T> createPageResult(List<T> result, Long totalNum){
    return new PageResult<>(totalNum, result);
  }
}
