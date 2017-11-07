package com.sellercube.usermanager.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.service.ChannelConfigService;
import com.sellercube.usermanager.server.base.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chenjing on 2017/10/12.
 *
 * @author Chenjing
 */
@RestController
@RequestMapping("/db/")
@Api(tags = "仓库移动打印服务调用接口访问数据库")
public class DaoController {

    private ChannelConfigService channelConfigService;

    private UserService userService;

    public DaoController() {
    }

    @Autowired
    public DaoController(ChannelConfigService var1, UserService var2) {
        this.channelConfigService = var1;
        this.userService = var2;
    }


    @GetMapping("/channel")
    @ApiOperation(value = "根据渠道名称获取渠道的打印方法")
    public Result reflect(@RequestParam("channelName") String name) {
        return ResultUtil.success(channelConfigService.selectByChannelName(name));
    }

    @GetMapping("/users/{id}")
    @ApiOperation(value = "根据用户id获取用户信息")
    public Result getUser(@PathVariable("id") String id) {
        return ResultUtil.success(userService.selectByPrimaryKey(id));
    }
}
