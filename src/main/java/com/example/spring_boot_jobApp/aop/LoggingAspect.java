package com.example.spring_boot_jobApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.spring_boot_jobApp.service.JobService.getJob(..)) || execution(* com.example.spring_boot_jobApp.service.JobService.getAllJobs(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method called: {}", jp.getSignature().getName());
    }

    @After("execution(* com.example.spring_boot_jobApp.service.JobService.getJob(..)) || execution(* com.example.spring_boot_jobApp.service.JobService.getAllJobs(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed: {}", jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.spring_boot_jobApp.service.JobService.getJob(..)) || execution(* com.example.spring_boot_jobApp.service.JobService.getAllJobs(..))")
    public void logMethodCrash(JoinPoint jp) {
        LOGGER.info("Method has some issues: {}", jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.spring_boot_jobApp.service.JobService.getJob(..)) || execution(* com.example.spring_boot_jobApp.service.JobService.getAllJobs(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        LOGGER.info("Method Executed Successfully: {}", jp.getSignature().getName());
    }
}
