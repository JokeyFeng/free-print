package com.sellercube.usermanager.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chenjing on 2017/11/7.
 *
 * @author Chenjing
 */
@RestController
@Api(tags = "用户")
public class UserController {
    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService var) {
        this.userService = var;
    }

    @GetMapping("/users")
    @ApiOperation(value = "获取所有的用户")
    public Result get(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                      @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        return ResultUtil.success(userService.list(pageNum, limit));
    }

    @GetMapping("/user/search")
    @ApiOperation(value = "根据用户名进行搜索")
    public Result search(@RequestParam(value = "userName") String storageName,
                         @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        return ResultUtil.success(userService.search(storageName, pageNum, limit));
    }
}
