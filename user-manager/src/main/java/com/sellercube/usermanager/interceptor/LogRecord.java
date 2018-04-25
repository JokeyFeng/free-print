package com.sellercube.usermanager.interceptor;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by chenjing on 2017/7/7.
 *
 * @author Chenjing
 */
@Component
@Aspect
@Slf4j
public class LogRecord {
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.sellercube.usermanager.rest.*.*(..))")
    public void log() {
    }


    @Before("log()")
    public void before(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("request url:" + request.getRequestURL().toString() + "\nhttp_method:" + request.getMethod()
                + "\nIP:" + request.getRemoteAddr() + "\nclass_method:"
                + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "\nargs: "
                + JSONObject.toJSONString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfterReturning(Object ret) throws Throwable {
        log.info("spend time : " + (System.currentTimeMillis() - startTime.get()) + " milliseconds}");
        startTime.remove();
    }
}


