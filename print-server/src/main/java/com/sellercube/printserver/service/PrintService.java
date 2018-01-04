package com.sellercube.printserver.service;

import com.sellercube.common.entity.Result;
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
     * 对手持的开箱入库进行模板打印
     *
     * @param openBox 实体
     * @return 打印成功
     * @throws Exception 异常
     */
    String printModel(OpenBox openBox) throws Exception;
}
