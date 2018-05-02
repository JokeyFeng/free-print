package com.sellercube.printserver.service;

import com.sellercube.common.entity.Result;
import com.sellercube.printserver.entity.IbnBox;
import com.sellercube.printserver.entity.OpenBox;
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
     * @throws Exception 异常
     */
    String print(Printer var) throws Exception;

    /**
     * 对手持的binCode进行模板打印
     * @param object
     * @return
     * @throws Exception
     */
    String printModel(Object object) throws Exception;
}
