package com.sellercube.printserver.service;

import com.sellercube.printserver.entity.PrintParam;

/**
 * 处理棒谷渠道的FBA打印
 * Created by Chenjing on 2017/10/13.
 * @author Chenjing
 */
public interface BanggoodService {

    /**
     * 对棒谷渠道的打印进行处理
     * @param printParam 打印的参数实体类
     * @return 打印成功
     * @throws Exception 向上抛异常
     */
    String process(PrintParam printParam) throws Exception;
}
