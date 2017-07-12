package com.sellercube.usermanager.rest;

import com.google.common.collect.ImmutableMap;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.entity.PrintType;
import com.sellercube.usermanager.server.base.service.PrintService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chenjing on 2017/7/8.
 */
@RestController
public class PrintController {

    @Autowired
    private PrintService printService;

    @PostMapping("/printtype")
    @ApiOperation(value = "新增打印类型", notes = "传入json对象进行新增操作")
    public Result insert(@RequestBody PrintType printType) {
        return ResultUtil.success(printService.insert(printType));
    }

    @GetMapping("/printtypes/search")
    @ApiOperation(value = "根据名称查询打印机类型")
    public Result insert(@RequestParam("name") String name,
                          @RequestParam(value = "pageNum", required = false) String pageNum,
                          @RequestParam(value = "limit", required = false) String limit) {
        return ResultUtil.success(printService.searchByName(name, pageNum, limit));
    }

    @GetMapping("/printtypes")
    @ApiOperation(value = "获取所有的打印机类型")
    public Result insert(@RequestParam(value = "pageNum", required = false) String pageNum,
                          @RequestParam(value = "limit", required = false) String limit) {
        return ResultUtil.success(printService.list(pageNum, limit));
    }

    @PutMapping("/printtypes/{id}")
    @ApiOperation(value = "修改打印机类型", notes = "根据id修改打印机类型，传入json对象")
    public Result put(@PathVariable("id") String id, @RequestBody PrintType printType) {
        printType.setId(Integer.valueOf(id));
        return ResultUtil.success(printService.updateByPrimaryKeySelective(printType));
    }

    @DeleteMapping("/printtypes/{id}")
    @ApiOperation(value = "删除打印机类型", notes = "根据id删除打印机类型")
    public Result del(@PathVariable String id) {
        return ResultUtil.success(printService.deleteByPrimaryKey(Integer.valueOf(id)));
    }

    @DeleteMapping("/printtypes")
    @ApiOperation(value = "删除打印机类型", notes = "批量删除打印机类型，多个id用逗号分隔")
    private Result b(@RequestBody String ids) {
        return ResultUtil.success(printService.deleteByPrimaryKey(ids));
    }

    @GetMapping("/printtypes/repeat")
    @ApiOperation(value = "判断是否重复", notes = "根据打印类型名称判断是否重复")
    public Result a(@RequestParam("printTypeName") String name) {
        return ResultUtil.success(ImmutableMap.of("isRepeat", printService.countByName(name)));
    }
}
