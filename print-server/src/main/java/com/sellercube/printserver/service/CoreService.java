package com.sellercube.printserver.service;

import com.sellercube.common.entity.PrintParam;
import com.sellercube.common.entity.Result;

/**
 * 处理打印的核心逻辑
 * Created by Chenjing on 2017/10/13.
 */
public interface CoreService {
    /**
     * 根据不同打印请求from字段调用不同的渠道打印
     */
    Result print(PrintParam printParam) throws Exception;
}
