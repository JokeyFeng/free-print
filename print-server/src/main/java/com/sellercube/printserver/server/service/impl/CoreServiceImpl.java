package com.sellercube.printserver.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.server.service.BanggoodService;
import com.sellercube.printserver.server.service.CoreService;
import com.sellercube.printserver.server.service.FlytService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 处理打印的核心逻辑
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
    public Result print(JSONObject jsonObject) throws Exception {
        String from = jsonObject.getString("from");
        Result result;
        switch (from) {
            case "bg":
                result = banggoodService.process(jsonObject);
                break;
            case "ft":
                result = flytService.process(jsonObject);
                break;
            default:
                result = ResultUtil.error("打印失败，from字段不支持");
                break;
        }
        return result;
    }
}
