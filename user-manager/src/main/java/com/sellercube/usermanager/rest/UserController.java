package com.sellercube.usermanager.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.entity.Opreator;
import com.sellercube.usermanager.server.base.service.OpreatorService;
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

    @Autowired
    private OpreatorService opreatorService;

    @PostMapping("/login")
    @ApiOperation(value = "登录接口")
    private Result login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
        return ResultUtil.success(userService.login(username, password));
    }

    @GetMapping("/operators/{id}")
    @ApiOperation(value = "查询操作员", notes = "根据id查询操作员信息")
    private Result get(@PathVariable("id") Integer id) {
        return ResultUtil.success(opreatorService.selectByPrimaryKey(id));
    }

    @PostMapping("/operator")
    @ApiOperation(value = "新增操作员", notes = "传入json对象进行新增操作")
    private Result insert(@RequestBody Opreator opreator) {
        return ResultUtil.success(opreatorService.insert(opreator));
    }

    @PutMapping("/operators/{id}")
    @ApiOperation(value = "更新操作员", notes = "传入json对象根据id更新操作员信息")
    private Result update(@RequestBody Opreator opreator, @PathVariable("id") Integer id) {
        opreator.setId(id);
        return ResultUtil.success(opreatorService.updateByPrimaryKeySelective(opreator));
    }

    @DeleteMapping("/operators/{id}")
    @ApiOperation(value = "删除操作员", notes = "根据id删除操作员")
    private Result delte(@PathVariable Integer id) {
        return ResultUtil.success(opreatorService.deleteByPrimaryKey(id));
    }

    @GetMapping("/operators")
    @ApiOperation(value = "获取所有操作员")
    private Result list() {
        return ResultUtil.success(opreatorService.list());
    }
}
