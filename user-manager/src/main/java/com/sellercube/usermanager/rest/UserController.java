package com.sellercube.usermanager.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.sellercube.common.entity.Result;
import com.sellercube.common.entity.View;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.entity.User;
import com.sellercube.usermanager.server.base.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chenjing on 2017/6/20.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录接口")
    private Result login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
        return ResultUtil.success(userService.login(username, password));
    }

    @PostMapping("/user")
    @ApiOperation(value = "新增操作员", notes = "传入json对象进行新增操作")
    private Result insert(@RequestBody User user) {
        return ResultUtil.success(userService.insert(user));
    }

    @PutMapping("/users/{id}")
    @ApiOperation(value = "更新操作员", notes = "传入json对象根据id更新操作员信息")
    private Result update(@RequestBody User user, @PathVariable("id") Integer id) {
        user.setId(id);
        return ResultUtil.success(userService.updateByPrimaryKeySelective(user));
    }

    @DeleteMapping("/users/{id}")
    @ApiOperation(value = "删除操作员", notes = "根据id删除操作员")
    private Result delte(@PathVariable Integer id) {
        return ResultUtil.success(userService.deleteByPrimaryKey(id));
    }

    @GetMapping("/users")
    @ApiOperation(value = "获取所有操作员")
    @JsonView(View.BaseView.class)
    private Result list(@RequestParam(value = "pageNum", required = false) String pageNum,
                        @RequestParam(value = "limit", required = false) String limit) {
        return ResultUtil.success(userService.list(pageNum,limit));
    }

    @GetMapping("/users/search")
    @ApiOperation(value = "搜索操作员", notes = "根据用户名或者登录名搜索操作员")
    @JsonView(View.BaseView.class)
    private Result search(@RequestParam(value = "username", required = false) String username,
                          @RequestParam(value = "account", required = false) String account,
                          @RequestParam(value = "pageNum", required = false) String pageNum,
                          @RequestParam(value = "limit", required = false) String limit) throws Exception {
        return ResultUtil.success(userService.search(username, account,pageNum,limit));
    }
}
