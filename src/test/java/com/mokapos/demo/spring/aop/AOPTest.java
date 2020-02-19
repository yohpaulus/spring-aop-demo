package com.mokapos.demo.spring.aop;

import com.mokapos.demo.spring.aop.aspect.AnnotationServiceAspect;
import com.mokapos.demo.spring.aop.aspect.ExecutionServiceAspect;
import com.mokapos.demo.spring.aop.aspect.WithinServiceAspect;
import com.mokapos.demo.spring.aop.target.ServiceTarget;
import com.mokapos.demo.spring.aop.target.impl.ServiceTargetImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

@Slf4j
public class AOPTest {

  @Test
  public void voidExecutionAspectTest() {
    ServiceTarget serviceTarget = new ServiceTargetImpl();
    AspectJProxyFactory aspectFactory = new AspectJProxyFactory(serviceTarget);

    ExecutionServiceAspect executionAspect = new ExecutionServiceAspect();
    aspectFactory.addAspect(executionAspect);

    ServiceTarget serviceTargetProxy = aspectFactory.getProxy();
    serviceTargetProxy.voidExecution();
  }

  @Test
  public void longExecutionAspectTest() {
    ServiceTarget serviceTarget = new ServiceTargetImpl();
    AspectJProxyFactory aspectFactory = new AspectJProxyFactory(serviceTarget);

    ExecutionServiceAspect executionAspect = new ExecutionServiceAspect();
    aspectFactory.addAspect(executionAspect);

    ServiceTarget serviceTargetProxy = aspectFactory.getProxy();
    serviceTargetProxy.longExecution(10L);
  }

  @Test
  public void voidWithinAspectTest() {
    ServiceTarget serviceTarget = new ServiceTargetImpl();
    AspectJProxyFactory aspectFactory = new AspectJProxyFactory(serviceTarget);

    WithinServiceAspect withinServiceAspect = new WithinServiceAspect();
    aspectFactory.addAspect(withinServiceAspect);

    ServiceTarget serviceTargetProxy = aspectFactory.getProxy();
    serviceTargetProxy.voidExecution();
    log.info("===================");
    serviceTargetProxy.longExecution(10L);
  }

  @Test
  public void logAroundAspectTest() {
    ServiceTarget serviceTarget = new ServiceTargetImpl();
    AspectJProxyFactory aspectFactory = new AspectJProxyFactory(serviceTarget);

    AnnotationServiceAspect annotationServiceAspect = new AnnotationServiceAspect();
    aspectFactory.addAspect(annotationServiceAspect);

    ServiceTarget serviceTargetProxy = aspectFactory.getProxy();
    serviceTargetProxy.voidExecution();
  }

  @Test
  public void logAroundValueAspectTest() {
    ServiceTarget serviceTarget = new ServiceTargetImpl();
    AspectJProxyFactory aspectFactory = new AspectJProxyFactory(serviceTarget);

    AnnotationServiceAspect annotationServiceAspect = new AnnotationServiceAspect();
    aspectFactory.addAspect(annotationServiceAspect);

    ServiceTarget serviceTargetProxy = aspectFactory.getProxy();
    Long result = serviceTargetProxy.longExecution(10L);
    log.info("execution result : {}", result);
  }

}
