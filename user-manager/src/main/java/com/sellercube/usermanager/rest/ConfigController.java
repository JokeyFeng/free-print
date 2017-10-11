package com.sellercube.usermanager.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.entity.Config;
import com.sellercube.usermanager.server.base.service.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chenjing on 2017/7/8.
 */
@RestController
@Api(tags = "打印机的配置")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @PostMapping("/config")
    @ApiOperation(value = "新增配置", notes = "传入json对象进行新增操作")
    public Result insert(@RequestBody Config config) throws Exception {
        return ResultUtil.success(configService.insertSelective(config));
    }

    @PutMapping("/configs/{id}")
    @ApiOperation(value = "更新配置", notes = "传入json对象根据id更新操作员信息")
    public Result update(@RequestBody Config config, @PathVariable("id") Integer id) {
        config.setId(id);
        return ResultUtil.success(configService.updateByPrimaryKeySelective(config));
    }

    @DeleteMapping("/configs")
    @ApiOperation(value = "批量删除配置", notes = "根据id批量删除 格式：1,2,3,4")
    public Result deleteAll(@RequestBody String ids) {
        return ResultUtil.success(configService.deleteByPrimaryKeyALL(ids));
    }

    @DeleteMapping("/configs/{id}")
    @ApiOperation(value = "删除配置", notes = "根据id删除配置")
    public Result delete(@PathVariable Integer id) {
        return ResultUtil.success(configService.deleteByPrimaryKey(id));
    }

    @GetMapping("/configs")
    @ApiOperation(value = "获取所有配置")
    public Result list(@RequestParam(value = "pageNum", required = false) String pageNum,
                        @RequestParam(value = "limit", required = false) String limit) {
        return ResultUtil.success(configService.list(pageNum, limit));
    }

    @GetMapping("/configs/search")
    @ApiOperation(value = "搜索配置", notes = "根据打印机名称、IP、MAC地址搜索配置")
    public Result search(@RequestParam(value = "printName", required = false) String printName,
                          @RequestParam(value = "ip", required = false) String ip,
                          @RequestParam(value = "mac", required = false) String mac,
                          @RequestParam(value = "pageNum", required = false) String pageNum,
                          @RequestParam(value = "limit", required = false) String limit) throws Exception {
        return ResultUtil.success(configService.search(printName, ip, mac, pageNum, limit));
    }

    @GetMapping("/configs/repeat")
    @ApiOperation(value = "判断打印机名称和IP是否重复", notes = "一个一个传入,否则以printName为准")
    public Result update(@RequestParam(value = "printName", required = false) String printName,
                          @RequestParam(value = "ip", required = false) String ip) throws Exception {
        return ResultUtil.success(configService.isConditionRepeat(printName, ip));
    }



}
