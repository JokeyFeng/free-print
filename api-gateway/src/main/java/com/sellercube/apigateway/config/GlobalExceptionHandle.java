package com.sellercube.apigateway.config;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sellercube.common.utils.ResultUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Chenjing on 2017/6/15.
 * zuul的统一异常处理
 */
public class GlobalExceptionHandle extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletResponse response = ctx.getResponse();
        Throwable throwable = ctx.getThrowable();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        try {
            response.getWriter().write(JSONObject.toJSONString(ResultUtil.error(throwable.getCause().toString())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
