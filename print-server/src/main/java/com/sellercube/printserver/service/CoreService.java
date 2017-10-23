package com.sellercube.printserver.service;

import com.sellercube.common.entity.PrintParam;
import com.sellercube.common.entity.Result;

/**
 * 处理打印的核心逻辑
 * Created by Chenjing on 2017/10/13.
 *
 * @author Chenjing
 */
public interface CoreService {
    /**
     * 根据不同打印请求from字段调用不同的渠道打印
     *
     * @param printParam 打印参数实体类
     * @return 项目的统一返回结果Result
     * @throws Exception 向上抛异常
     */
    Result print(PrintParam printParam) throws Exception;
}
