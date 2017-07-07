package com.sellercube.printserver.server.base.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Chenjing on 2017/6/30.
 */
public interface BaseService {

    /**
     * 打印接口处理核心
     *
     * @param jsonObject
     * @return
     */
    void process(JSONObject jsonObject, HttpServletRequest request) throws Exception;
}
