package com.mokapos.demo.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class ExecutionServiceAspect {

  @Pointcut("execution(void com.mokapos.demo.spring.aop..ServiceTarget.*())")
  public void voidPointcut() {}

  @Before("voidPointcut()")
  public void voidExecutionAdvice() {
    log.info("ASPECT before execution");
  }

  ///////////////////////////////////////////////////////////////////////////

  @Pointcut("execution(* com.mokapos.demo.spring.aop..ServiceTarget.*(Long))")
  public void longPointcut() {}

  @Pointcut("args(longValue,..)")
  public void longArgsPointcut(Long longValue) {}

  @Before("longPointcut() && longArgsPointcut(longValue)")
  public void longExecutionAdvice(Long longValue) {
    log.info("ASPECT before execution with value : {}", longValue);
  }

}
