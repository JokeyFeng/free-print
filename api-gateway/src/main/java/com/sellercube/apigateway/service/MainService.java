package com.sellercube.apigateway.service;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;

/**
 * Created by Chenjing on 2017/10/13.
 */
public interface MainService {
    Result process(JSONObject jsonObject) throws Exception;
}
