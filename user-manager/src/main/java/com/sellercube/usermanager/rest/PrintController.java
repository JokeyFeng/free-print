package com.sellercube.usermanager.rest;

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
    private Result insert(@RequestBody PrintType printType) {
        return ResultUtil.success(printService.insert(printType));
    }

    @GetMapping("/printtypes/search")
    @ApiOperation(value = "根据名称查询打印机类型")
    private Result insert(@RequestParam("name") String name,
                          @RequestParam(value = "pageNum", required = false) String pageNum,
                          @RequestParam(value = "limit", required = false) String limit) {
        return ResultUtil.success(printService.searchByName(name, pageNum, limit));
    }

    @GetMapping("/printtypes")
    @ApiOperation(value = "获取所有的打印机类型")
    private Result insert(@RequestParam(value = "pageNum", required = false) String pageNum,
                          @RequestParam(value = "limit", required = false) String limit) {
        return ResultUtil.success(printService.list(pageNum,limit));
    }

    @PutMapping("/printtypes/{id}")
    @ApiOperation(value = "根据名称查询打印机类型", notes = "根据id修改打印机类型，传入json对象")
    private Result put(@PathVariable("id") String id, @RequestBody PrintType printType) {
        printType.setId(Integer.valueOf(id));
        return ResultUtil.success(printService.updateByPrimaryKey(printType));
    }

    @DeleteMapping("/printtypes/{id}")
    @ApiOperation(value = "删除打印机类型", notes = "根据id删除打印机类型")
    private Result del(@PathVariable String id) {
        return ResultUtil.success(printService.deleteByPrimaryKey(Integer.valueOf(id)));
    }
}