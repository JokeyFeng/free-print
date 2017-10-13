package com.sellercube.printserver.service.impl;

import com.sellercube.common.entity.PrintParam;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.service.BanggoodService;
import com.sellercube.printserver.service.CoreService;
import com.sellercube.printserver.service.FlytService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chenjing on 2017/7/13.
 */
@Service
public class CoreServiceImpl implements CoreService {

    private static final Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);

    @Autowired
    private FlytService flytService;

    @Autowired
    private BanggoodService banggoodService;

    @Override
    public Result print(PrintParam param) throws Exception {
        String from = param.getFrom();
        Result result;
        switch (from) {
            case "bg":
                result = banggoodService.process(param);
                break;
            case "ft":
                result = flytService.process(param);
                break;
            default:
                result = ResultUtil.error("打印失败，from字段不支持");
                break;
        }
        return result;
    }
}
