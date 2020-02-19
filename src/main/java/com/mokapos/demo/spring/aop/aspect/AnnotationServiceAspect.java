package com.mokapos.demo.spring.aop.aspect;

import com.mokapos.demo.spring.aop.annotation.LogAroundValue;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AnnotationServiceAspect {

  @Pointcut("@annotation(com.mokapos.demo.spring.aop.annotation.LogAround)")
  public void logAroundPointcut() {}

  @Around("logAroundPointcut()")
  public Object logAroundAspect(ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("ASPECT before execution");
    Object result = joinPoint.proceed();
    log.info("ASPECT after execution");
    return result;
  }

  ////////////////////////////////////////////////////////////////////////////////////

  @Pointcut("@annotation(logAroundValue)")
  public void logAroundValuePointcut(LogAroundValue logAroundValue) {}

  @Around("logAroundValuePointcut(logAroundValue)")
  public Object logAroundValueAspect(ProceedingJoinPoint joinPoint,
      LogAroundValue logAroundValue) throws Throwable {
    log.info("ASPECT before execution");
    log.info("ASPECT log around value : {}", logAroundValue.value());
    Object result = joinPoint.proceed();
    log.info("ASPECT after execution");
    return result;
  }
}
