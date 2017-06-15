package com.sellercube.apigateway.config;

import com.sellercube.apigateway.interceptor.AuthHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Chenjing on 2017/6/15.
 */
@Configuration
public class FilterConfig {

    @Bean
    public AuthHandlerInterceptor authFilter() {
        return new AuthHandlerInterceptor();
    }

    @Bean
    public GlobalExceptionHandle exceptionHandle() {
        return new GlobalExceptionHandle();
    }
}
