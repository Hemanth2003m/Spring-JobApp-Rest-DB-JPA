package com.hems.SpringBootRest.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution(* com.hems.SpringBootRest.service.JobService.*(..))")
    public void logMethodCall(){
        LOGGER.info("Method call");
    }
    @After("execution(* com.hems.SpringBootRest.service.JobService.*(..))")
    public void logMethodExecuted(){
        LOGGER.info("Method executed");
    }
}
