package com.sellercube.apigateway.server.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Chenjing on 2017/7/14.
 */
public interface MainService {
    JSONObject process(JSONObject jsonObject) throws Exception;
}
