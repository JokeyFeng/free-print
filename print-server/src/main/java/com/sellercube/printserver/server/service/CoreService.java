package com.sellercube.printserver.server.service;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;

/**
 * Created by Chenjing on 2017/7/13.
 */
public interface CoreService {
    Result print(JSONObject jsonObject) throws Exception;
}
