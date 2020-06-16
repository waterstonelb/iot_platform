package com.example.iot_manager.config;


import com.example.iot_manager.vo.ResponseVO;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @author liangbin
 * @create 2020/6/12
 */
@Slf4j
@Aspect
@Order(1)
@Component
public class ParamCheckAspect {


  @Around("@annotation(com.example.iot_manager.config.ParamCheck)")
  public Object around(final ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("进入切面");
    Map<String, Object> params = getNameAndValue(joinPoint);

    if ((int)params.get("page") < 0  || (int) params.get("page") < 0 ) {
      log.info("分页参数错误");
      return ResponseVO.buildFailure("参数错误，请检查分页参数合法性");
    }else
      return joinPoint.proceed();
  }

  /**
   * 获取参数Map集合
   */
  Map<String, Object> getNameAndValue(ProceedingJoinPoint joinPoint) {
    Map<String, Object> param = new HashMap<>();

    Object[] paramValues = joinPoint.getArgs();
    String[] paramNames = ((CodeSignature)joinPoint.getSignature()).getParameterNames();

    for (int i = 0; i < paramNames.length; i++) {
      param.put(paramNames[i], paramValues[i]);
    }

    return param;
  }
}
