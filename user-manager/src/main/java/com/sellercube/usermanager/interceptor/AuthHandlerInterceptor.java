package com.sellercube.usermanager.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class AuthHandlerInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(AuthHandlerInterceptor.class);

    @Value("${access.token}")
    private String secret;

    private static final String SWAGGER = "swagger";

    private static final String SWAGGER_URI = "/v2/api-docs";

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
            response.getWriter().write(JSONObject.toJSONString(ResultUtil.authFail("请先登录")));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 处理器执行完毕之后
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 请求处理完成之后
    }
}
