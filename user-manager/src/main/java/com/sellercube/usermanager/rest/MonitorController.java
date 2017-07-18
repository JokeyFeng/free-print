package com.sellercube.usermanager.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.service.MonitorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chenjing on 2017/7/18.
 */
@RestController
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @GetMapping("/monitor/list")
    @ApiOperation(value = "分页获取监控信息")
    public Result a(@RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum,
                    @RequestParam(value = "limit", required = false, defaultValue = "10") String limit) {
        return ResultUtil.success(monitorService.list(pageNum, limit));
    }
}
