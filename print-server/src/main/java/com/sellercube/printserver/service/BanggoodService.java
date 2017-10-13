package com.sellercube.printserver.service;

import com.sellercube.common.entity.PrintParam;
import com.sellercube.common.entity.Result;

/**
 * 处理棒谷渠道的FBA打印
 * Created by Chenjing on 2017/10/13.
 */
public interface BanggoodService {

    Result process(PrintParam printParam) throws Exception;
}
