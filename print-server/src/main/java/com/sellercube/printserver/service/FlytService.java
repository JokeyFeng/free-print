package com.sellercube.printserver.service;

import com.sellercube.common.entity.PrintParam;
import com.sellercube.common.entity.Result;

/**
 * 处理飞特的面单打印
 * Created by Chenjing on 2017/10/13.
 * @author Chenjing
 */
public interface FlytService {
    /**
     * 对飞特渠道的打印进行处理
     *
     * @param printParam 打印参数的实体类
     * @return 项目统一的返回结果
     * @throws Exception 向上抛异常
     */
    Result process(PrintParam printParam) throws Exception;
}
