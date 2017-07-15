package com.sellercube.printserver.server.service;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;

/**
 * Created by Chenjing on 2017/7/15.
 */
public interface FlytService {
    /**
     * 处理飞特接口
     */
    Result process(JSONObject jsonObject) throws Exception;
}
