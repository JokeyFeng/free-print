package com.sellercube.usermanager.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.collect.ImmutableMap;
import com.sellercube.common.entity.Result;
import com.sellercube.common.entity.View;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.entity.Config;
import com.sellercube.usermanager.server.base.service.ConfigService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/configs/{id}")
    @ApiOperation(value = "更新配置", notes = "传入json对象根据id更新操作员信息")
    private Result update(@RequestBody Config config, @PathVariable("id") Integer id) {
        config.setId(id);
        return ResultUtil.success(configService.updateByPrimaryKeySelective(config));
    }

    @DeleteMapping("/configs/{id}")
    @ApiOperation(value = "删除配置", notes = "根据id删除配置")
    private Result delte(@PathVariable Integer id) {
        return ResultUtil.success(configService.deleteByPrimaryKey(id));
    }

    @GetMapping("/configs")
    @ApiOperation(value = "获取所有配置")
    private Result list(@RequestParam(value = "pageNum", required = false) String pageNum,
                        @RequestParam(value = "limit", required = false) String limit) {
        return ResultUtil.success(configService.list(pageNum, limit));
    }

    @GetMapping("/configs/search")
    @ApiOperation(value = "搜索配置", notes = "根据打印机名称、IP、MAC地址搜索配置")
    private Result search(@RequestParam(value = "printName", required = false) String printName,
                          @RequestParam(value = "ip", required = false) String ip,
                          @RequestParam(value = "mac", required = false) String mac,
                          @RequestParam(value = "pageNum", required = false) String pageNum,
                          @RequestParam(value = "limit", required = false) String limit) throws Exception {
        return ResultUtil.success(configService.search(printName, ip, mac, pageNum, limit));
    }

    @GetMapping("/configs/repeat")
    @ApiOperation(value = "判断打印机名称是否重复", notes = "一次传入一个参数,否则将以参数为name的结果为准")
    private Result update(@RequestParam(value = "printName", required = false) String printName) throws Exception {
        return ResultUtil.success(ImmutableMap.of("isRepeat",configService.isConditionRepeat(printName)));
    }



}
