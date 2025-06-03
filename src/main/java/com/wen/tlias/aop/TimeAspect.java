package com.wen.tlias.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//计算方法用时的切面类
@Slf4j
@Component
@Aspect
public class TimeAspect {

  @Around("execution(* com.wen.tlias.service.*.*(..))")
  public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    // 前置的
    long begin = System.currentTimeMillis();
    Object p = proceedingJoinPoint.proceed();
    // 后置的
    long after = System.currentTimeMillis();
    log.info("方法:" + proceedingJoinPoint.getSignature() + ",耗时:{}ms", after - begin);
    return p;
  }
}
