package com.sellercube.printserver.service;

import com.sellercube.common.entity.Result;
import com.sellercube.printserver.entity.PrintReqBody;

/**
 * Created by Chenjing on 2017/11/10.
 *
 * @author Chenjing
 */
public interface TmsService {
    /**
     * 对TMS 手持打印
     *
     * @param printReqBody 请求实体
     * @return {@link Result}
     */
    Result print(PrintReqBody printReqBody) throws Exception;
}
