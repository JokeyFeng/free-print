package com.sellercube.usermanager.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.entity.PrintConfig;
import com.sellercube.usermanager.server.base.service.PrintConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Chenjing on 2017/8/25.
 *
 * @author Chenjing
 */
@RestController
@RequestMapping("/print")
@Api(tags = "手持IP配置")
public class PrintConfigController {

    private PrintConfigService printConfigService;


    public PrintConfigController() {
    }

    @Autowired
    public PrintConfigController(PrintConfigService var1) {
        this.printConfigService = var1;
    }

    @GetMapping("/config/list")
    @ApiOperation(value = "获取手持的IP配置信息")
    public Result list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                       @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        return ResultUtil.success(printConfigService.list(pageNum, limit));
    }

    @PostMapping("/config")
    @ApiOperation(value = "插入手持的IP配置信息")
    public Result post(@RequestBody PrintConfig printConfig) {
        printConfig.setModifyDate(new Date());
        printConfig.setCreateDate(new Date());
        return ResultUtil.success(printConfigService.insertSelective(printConfig));
    }

    @PutMapping("/config")
    @ApiOperation(value = "修改手持的IP配置信息")
    public Result put(@RequestBody PrintConfig printConfig) {
        printConfig.setModifyDate(new Date());
        return ResultUtil.success(printConfigService.updateByPrimaryKeySelective(printConfig));
    }

    @DeleteMapping("/config/{id}")
    @ApiOperation(value = "删除手持IP配置的信息", notes = "根据id删除手持IP配置的信息")
    public Result deleteById(@PathVariable("id") String id) {
        return ResultUtil.success(printConfigService.deleteByPrimaryKey(id));
    }

    @DeleteMapping("/config")
    @ApiOperation(value = "删除手持IP配置的信息", notes = "批量删除手持IP配置的信息,多个id用英文逗号分隔")
    public Result deleteByIds(@RequestBody String ids) {
        return ResultUtil.success(printConfigService.deleteByPrimaryKeyALL(ids));
    }

    @GetMapping("/config/search")
    @ApiOperation(value = "根据条件搜索手持IP配置的信息", notes = "根据传入条件来进行搜索")
    public Result searchByCondition(@RequestParam(value = "operateId", required = false) String operateUserId,
                                    @RequestParam(value = "warehouseId", required = false) Integer warehouseId,
                                    @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) throws Exception {
        return ResultUtil.success(printConfigService.search(operateUserId, warehouseId, pageNum, limit));
    }
}
