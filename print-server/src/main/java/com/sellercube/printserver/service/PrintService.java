package com.sellercube.printserver.service;

import com.sellercube.common.entity.Result;
import com.sellercube.printserver.entity.Printer;

/**
 * Created by Chenjing on 2017/11/10.
 *
 * @author Chenjing
 */
public interface PrintService {
    /**
     * 对TMS 手持打印
     *
     * @param var 请求实体
     * @return {@link Result}
     */
    Result print(Printer var) throws Exception;
}
