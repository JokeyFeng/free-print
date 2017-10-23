package com.sellercube.printserver.service;

import com.sellercube.common.entity.PrintParam;
import com.sellercube.common.entity.Result;

/**
 * 处理棒谷渠道的FBA打印
 * Created by Chenjing on 2017/10/13.
 * @author Chenjing
 */
public interface BanggoodService {

    /**
     * 对棒谷渠道的打印进行处理
     * @param printParam 打印的参数实体类
     * @return 项目的统一返回结果
     * @throws Exception 向上抛异常
     */
    Result process(PrintParam printParam) throws Exception;
}
