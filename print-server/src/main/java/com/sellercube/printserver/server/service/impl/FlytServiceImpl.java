package com.sellercube.printserver.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.server.entity.Monitor;
import com.sellercube.printserver.server.mapper.MonitorMapper;
import com.sellercube.printserver.server.service.FlytService;
import com.sellercube.printserver.utils.CoreUtil;
import com.sellercube.printserver.utils.PrintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 飞特接口
 * Created by Chenjing on 2017/7/15.
 */
@Service
public class FlytServiceImpl implements FlytService {

    @Autowired
    private MonitorMapper monitorMapper;

    @Override
    public Result process(JSONObject jsonObject) throws Exception {
        String path = null;
        JSONObject data = jsonObject.getJSONObject("Data");
        Integer monitorId = jsonObject.getInteger("monitorId");
        switch (data.getString("Format")) {
            case "PDF":
                path = CoreUtil.base64(data.getString("Label"), "pdf");
                break;
            case "PNG":
                path = CoreUtil.base64(data.getString("Label"), "png");
                break;
            default:
                break;
        }

        if (!Objects.equals(null, path) && !Objects.equals("", path)) {
            PrintUtil.printPDF(path);
            monitorMapper.deleteByPrimaryKey(monitorId);
            return ResultUtil.success("打印成功");
        }
        Monitor monitor = new Monitor();
        monitor.setId(monitorId);
        monitor.setStatus("打印失败");
        monitor.setId(monitorId);
        monitorMapper.updateByPrimaryKeySelective(monitor);
        return ResultUtil.error("打印失败");
    }
}
