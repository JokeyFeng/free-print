package com.sellercube.printserver.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.HttpStatus;
import com.sellercube.common.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by chenjing on 2017/7/7.
 *
 * @author Chenjing
 */
@Component
@Slf4j
public class AuthHandlerInterceptor extends HandlerInterceptorAdapter {

    @Value("${auth.secret}")
    private String secret;

    private static final String SWAGGER = "swagger";

    private static final String SWAGGER_URI = "/v2/api-docs";

    @SuppressWarnings("all")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().contains(SWAGGER) || request.getRequestURI().contains(SWAGGER_URI)) {
            return true;
        }

        String token = request.getHeader("Authorization");
        if (!Objects.equals(secret, token)) {
            log.error("auth fail");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSONObject.toJSONString(ResultUtil.create(HttpStatus.AUTH_FAIL, null)));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // 处理器执行完毕之后
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 请求处理完成之后
    }
}
