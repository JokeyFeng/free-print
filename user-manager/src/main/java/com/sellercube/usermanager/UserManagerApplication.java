package com.sellercube.usermanager;

import com.sellercube.usermanager.interceptor.AuthHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
@SpringBootApplication
public class UserManagerApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(UserManagerApplication.class, args);
    }


    private AuthHandlerInterceptor authHandlerInterceptor;

    @Autowired
    public void setAuthHandlerInterceptor(AuthHandlerInterceptor var1) {
        this.authHandlerInterceptor = var1;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authHandlerInterceptor).addPathPatterns("/**");
    }
}
