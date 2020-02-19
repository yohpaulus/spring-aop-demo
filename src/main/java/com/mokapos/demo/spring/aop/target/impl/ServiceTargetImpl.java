package com.mokapos.demo.spring.aop.target.impl;

import com.mokapos.demo.spring.aop.annotation.LogAround;
import com.mokapos.demo.spring.aop.annotation.LogAroundValue;
import com.mokapos.demo.spring.aop.target.ServiceTarget;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServiceTargetImpl implements ServiceTarget {

  @LogAround
  @Override
  public void voidExecution() {
    log.info("TARGET void execution");
//    log.error("TARGET void execution. Error", new RuntimeException());
  }

  @LogAroundValue("THIS IS LONG EXECUTION")
  @Override
  public Long longExecution(Long longValue) {
    log.info("TARGET long execution with value : {}", longValue);
    return longValue / 2;
  }

  @Override
  public String stringExecution(String stringValue) {
    log.info("TARGET string execution with value : {}", stringValue);
    return stringValue + " - TARGET";
  }
}
