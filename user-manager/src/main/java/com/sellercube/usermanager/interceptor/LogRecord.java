package com.sellercube.usermanager.interceptor;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by chenjing on 2017/7/7.
 */
@Component
@Aspect
public class LogRecord {
    private Logger logger = LoggerFactory.getLogger(LogRecord.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.sellercube.usermanager.rest.*.*(..))")
    public void log() {
    }


    @Before("log()")
    public void before(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("【request url : " + request.getRequestURL().toString() + ",http_method : " + request.getMethod()
                + ",IP : " + request.getRemoteAddr() + ",class_method : "
                + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + ",args : "
                + Arrays.toString(joinPoint.getArgs()) + "】");

    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfterReturning(Object ret) throws Throwable {
        logger.info("{result : " + ret + "\nspend time : " + (System.currentTimeMillis() - startTime.get()) + " milliseconds}");
    }
}


