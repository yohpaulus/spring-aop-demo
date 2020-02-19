package com.mokapos.demo.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class WithinServiceAspect {

  @Pointcut("within(com.mokapos.demo.spring.aop..*)")
  public void withinServiceTargetPointcut() {}

  @After("withinServiceTargetPointcut()")
  public void withinServiceTargetAdvice() {
    log.info("ASPECT after execution");
  }

}
