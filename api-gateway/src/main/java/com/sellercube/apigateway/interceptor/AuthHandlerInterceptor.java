package com.sellercube.apigateway.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sellercube.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by Chenjing on 2017/6/15.
 * 权限认证
 * 配置完之后需要在spring容器进行注册
 */
public class AuthHandlerInterceptor extends ZuulFilter {

    private final Logger log = LoggerFactory.getLogger(AuthHandlerInterceptor.class);

    @Value("${auth.secret}")
    private String secret;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        log.info("【请求路径:{},方式:{},IP:{}】 ", request.getRequestURL().toString(), request.getMethod(), request.getRemoteAddr());
        if (request.getRequestURI().contains("swagger") || request.getRequestURI().contains("/v2/api-docs")) {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            return null;
        }
        String token = request.getHeader("Authorization");
        if (Objects.equals(token, secret)) {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);// 设值，让下一个Filter看到上一个Filter的状态
            return null;
        } else {
            ctx.setSendZuulResponse(false);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            try {
                response.getWriter().write(JSONObject.toJSONString(ResultUtil.authFail(null)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ctx.set("isSuccess", false);
            return null;
        }
    }
}
