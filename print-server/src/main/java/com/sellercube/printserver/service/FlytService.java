package com.sellercube.printserver.service;

import com.sellercube.common.entity.PrintParam;
import com.sellercube.common.entity.Result;

/**
 * 处理飞特的面单打印
 * Created by Chenjing on 2017/10/13.
 */
public interface FlytService {
    Result process(PrintParam printParam) throws Exception;
}
