package com.mokapos.demo.spring.aop.target;

public interface ServiceTarget {

  void voidExecution();

  Long longExecution(Long longValue);

  String stringExecution(String stringValue);

}
