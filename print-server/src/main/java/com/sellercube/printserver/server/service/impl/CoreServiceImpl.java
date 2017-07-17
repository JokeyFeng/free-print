package com.sellercube.printserver.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.server.entity.Monitor;
import com.sellercube.printserver.server.mapper.MonitorMapper;
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
    private MonitorMapper monitorMapper;

    @Autowired
    private FlytService flytService;

    @Autowired
    private BanggoodService banggoodService;

    @Override
    public Result print(JSONObject jsonObject) throws Exception {
        Monitor monitor = new Monitor();
        Integer monitorId = jsonObject.getInteger("monitorId");
        monitor.setId(monitorId);
        monitor.setStatus("打印中");
        monitorMapper.updateByPrimaryKeySelective(monitor);
        String from = jsonObject.getString("from");
        Result result;
        switch (from) {
            case "bg":
                result = banggoodService.process(jsonObject);
                monitorMapper.deleteByPrimaryKey(monitorId);
                break;
            case "ft":
                result = flytService.process(jsonObject);
                monitorMapper.deleteByPrimaryKey(monitorId);
                break;
            default:
                result = ResultUtil.error("打印失败，from字段不支持");
                monitor.setStatus("打印失败");
                monitorMapper.updateByPrimaryKeySelective(monitor);
                break;
        }
        return result;
    }
}
