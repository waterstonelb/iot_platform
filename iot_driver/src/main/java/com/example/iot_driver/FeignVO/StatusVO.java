package com.example.iot_driver.FeignVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusVO {
  private int deviceId;
  private int status;
}
