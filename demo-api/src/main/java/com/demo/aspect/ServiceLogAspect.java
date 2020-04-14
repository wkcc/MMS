package com.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogAspect{
    final static Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    @Around("execution(* com.demo.service.impl..*..*(..))")
    public Object recordTime (ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("=======开始执行{}.{}=====",
                joinPoint.getTarget().getClass(),joinPoint.getSignature().getName());
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long castTime = endTime - startTime;
        if (castTime > 3000){
            logger.error("====超时运行{}===",
                    joinPoint.getTarget().getClass());
        }
        return result;
    }
}
