package com.sellercube.usermanager.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.service.ChannelConfigService;
import com.sellercube.usermanager.server.base.service.PrintBindService;
import com.sellercube.usermanager.server.base.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chenjing on 2017/10/12.
 */
@RestController
@RequestMapping("/db/")
@Api(tags = "仓库移动打印服务调用接口访问数据库")
public class DaoController {

    @Autowired
    private PrintBindService printBindService;

    @Autowired
    private ChannelConfigService channelConfigService;

    @Autowired
    private UserService userService;

    @GetMapping("/users/ip")
    @ApiOperation(value = "根据查询条件获取用户所绑定的打印机IP")
    public Result printBind(@RequestParam("userId") String userId,
                            @RequestParam("printType") String printType,
                            @RequestParam("isEnable") boolean isEnable) {
        return ResultUtil.success(printBindService.listByCondition(userId, printType, isEnable));
    }

    @GetMapping("/channel")
    @ApiOperation(value = "根据渠道名称获取渠道的打印方法")
    public Result reflect(@RequestParam("channelName") String name) {
        return ResultUtil.success(channelConfigService.selectByChannelName(name));
    }

    @GetMapping("/users/{id}")
    public Result getUser(@PathVariable("id") int id) {
        return ResultUtil.success(userService.selectByPrimaryKey(id));
    }
}
