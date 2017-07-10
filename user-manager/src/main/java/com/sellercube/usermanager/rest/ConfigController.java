package com.sellercube.usermanager.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.entity.Config;
import com.sellercube.usermanager.server.base.service.ConfigService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chenjing on 2017/7/8.
 */
@RestController
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @PostMapping("/config")
    @ApiOperation(value = "新增配置", notes = "传入json对象进行新增操作")
    public Result insert(@RequestBody Config config) throws Exception {
        return ResultUtil.success(configService.insert(config));
    }

}
