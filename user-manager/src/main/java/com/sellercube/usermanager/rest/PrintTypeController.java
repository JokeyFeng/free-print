package com.sellercube.usermanager.rest;

import com.google.common.collect.ImmutableMap;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.entity.PrintType;
import com.sellercube.usermanager.server.base.service.PrintTypeService;
import com.sellercube.usermanager.server.base.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Chenjing on 2017/7/8.
 *
 * @author Chenjing
 */
@RestController
@Api(tags = "打印类型")
public class PrintTypeController {

    private PrintTypeService printTypeService;

    private UserService userService;

    public PrintTypeController() {
    }

    @Autowired
    public PrintTypeController(PrintTypeService var1, UserService var2) {
        this.printTypeService = var1;
        this.userService = var2;
    }


    @PostMapping("/printtype")
    @ApiOperation(value = "新增打印类型", notes = "传入json对象进行新增操作")
    public Result insert(@RequestBody PrintType printType) {
        printType.setCreateTime(new Date());
        printType.setUpdateTime(new Date());
        printType.setCreator(userService.selectByPrimaryKey(printType.getCreator()).getUsername());
        printType.setUpdator(printType.getCreator());
        return ResultUtil.success(printTypeService.insertSelective(printType));
    }

    @GetMapping("/printtypes/search")
    @ApiOperation(value = "根据名称查询打印机类型")
    public Result insert(@RequestParam("name") String name,
                         @RequestParam(value = "pageNum", required = false) String pageNum,
                         @RequestParam(value = "limit", required = false) String limit) {
        return ResultUtil.success(printTypeService.searchByName(name, pageNum, limit));
    }

    @GetMapping("/printtypes")
    @ApiOperation(value = "获取所有的打印机类型")
    public Result insert(@RequestParam(value = "pageNum", required = false) String pageNum,
                         @RequestParam(value = "limit", required = false) String limit) {
        return ResultUtil.success(printTypeService.list(pageNum, limit));
    }

    @PutMapping("/printtypes/{id}")
    @ApiOperation(value = "修改打印机类型", notes = "根据id修改打印机类型，传入json对象")
    public Result put(@PathVariable("id") String id, @RequestBody PrintType printType) {
        printType.setId(Integer.valueOf(id));
        printType.setUpdateTime(new Date());
        printType.setUpdator(userService.selectByPrimaryKey(printType.getUpdator()).getUsername());
        return ResultUtil.success(printTypeService.updateByPrimaryKeySelective(printType));
    }

    @DeleteMapping("/printtypes/{id}")
    @ApiOperation(value = "删除打印机类型", notes = "根据id删除打印机类型")
    public Result del(@PathVariable String id) {
        return ResultUtil.success(printTypeService.deleteByPrimaryKey(id));
    }

    @DeleteMapping("/printtypes")
    @ApiOperation(value = "删除打印机类型", notes = "批量删除打印机类型，多个id用逗号分隔")
    public Result b(@RequestBody String ids) {
        return ResultUtil.success(printTypeService.deleteByPrimaryKeyALL(ids));
    }

    @GetMapping("/printtypes/repeat")
    @ApiOperation(value = "判断是否重复", notes = "根据打印类型名称判断是否重复")
    public Result a(@RequestParam("printTypeName") String name) {
        return ResultUtil.success(ImmutableMap.of("isRepeat", printTypeService.countByName(name)));
    }
}
