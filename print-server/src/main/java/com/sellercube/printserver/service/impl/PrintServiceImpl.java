package com.sellercube.printserver.service.impl;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.entity.PrintMethodEnum;
import com.sellercube.printserver.entity.Printer;
import com.sellercube.printserver.service.PrintService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * Created by Chenjing on 2017/11/10.
 *
 * @author Chenjing
 */
@Service
@Slf4j
public class PrintServiceImpl implements PrintService {

    @Override
    public Result print(Printer param) throws Exception {
        PrintMethodEnum printMethodEnum = Enum.valueOf(PrintMethodEnum.class, param.getPrintMethod());
        Class<?> clazz = Class.forName(printMethodEnum.getClazz());
        Method method = clazz.getMethod(printMethodEnum.getMethod(), String.class);
        Object object = clazz.newInstance();
        method.invoke(object, param.getBase64Str());
        return ResultUtil.success("打印成功");
    }
}
