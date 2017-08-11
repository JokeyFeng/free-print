package com.sellercube.usermanager.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.service.PrintBindService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author:Administrator
 * Date: 2017/7/10
 * Email:JokeyFeng@foxmail.com
 * Version:1.0.0
 */
@RestController
public class PrintBindController {
    @Autowired
    private PrintBindService printBindService;

    @PostMapping("/binding")
    @ApiOperation(value = "新增【打印绑定】的信息", notes = "传入json对象进行新增操作")
    public Result insert(@RequestParam("printNameId") Integer printNameId,
                         @RequestParam("printTypeId") Integer printTypeId,
                         @RequestParam("isEnable") boolean isEnable,
                         @RequestParam("userId") Integer userId,
                         @RequestParam("file") MultipartFile file,
                         @RequestParam("creator") String creator) throws Exception {
        return ResultUtil.success(printBindService.insertSelective(printNameId, printTypeId, isEnable, userId, file, creator));
    }

    @PostMapping("/bindings/{id}")
    @ApiOperation(value = "修改【打印绑定】的信息", notes = "传入json对象根据id更新【打印绑定】的信息")
    public Result update(@PathVariable("id") Integer id,
                         @RequestParam("printNameId") String printNameId,
                         @RequestParam("printTypeId") Integer printTypeId,
                         @RequestParam("isEnable") boolean isEnable,
                         @RequestParam("userId") Integer userId,
                         @RequestParam(value = "file", required = false) MultipartFile file,
                         @RequestParam("updator") String updator) throws Exception {
        return ResultUtil.success(printBindService.updateByPrimaryKeySelective(id, Integer.valueOf(printNameId), printTypeId, isEnable, userId, file, updator));
    }

    @DeleteMapping("/bindings/{id}")
    @ApiOperation(value = "删除【打印绑定】的信息", notes = "根据id删除【打印绑定】的信息")
    public Result deleteById(@PathVariable("id") Integer id) {
        return ResultUtil.success(printBindService.deleteByPrimaryKey(id));
    }

    @DeleteMapping("/bindings")
    @ApiOperation(value = "删除【打印绑定】的信息", notes = "批量删除【打印绑定】的信息")
    public Result deleteByIds(@RequestBody String ids) {
        return ResultUtil.success(printBindService.deleteByKeys(ids));
    }

    @GetMapping("/bindings")
    @ApiOperation(value = "分页获取所有【打印绑定】的信息")
    public Result getByPage(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        return ResultUtil.success(printBindService.getByPage(pageNum, limit));
    }

    @GetMapping("/bindings/search")
    @ApiOperation(value = "根据条件搜索【打印绑定】的信息", notes = "根据传入的条件来进行搜索")
    public Result searchByCondition(@RequestParam(value = "configId", required = false) Integer configId,
                                     @RequestParam(value = "typeId", required = false) Integer typeId,
                                     @RequestParam(value = "isEnable", required = false) Boolean isEnable,
                                     @RequestParam(value = "userId", required = false) Integer userId,
                                     @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) throws Exception {
        return ResultUtil.success(printBindService.searchByCondition(configId, typeId, isEnable, userId, pageNum, limit));
    }

    @GetMapping("/bindings/dropdown")
    @ApiOperation(value = "绑定页面下拉菜单的选项")
    public Result a() {
        return ResultUtil.success(printBindService.dropdwon());
    }

}
