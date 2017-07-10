package com.sellercube.usermanager.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.PrintBind;
import com.sellercube.usermanager.server.base.service.PrintBindService;
import com.sellercube.usermanager.vo.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/printbind")
    @ApiOperation(value = "新增【打印绑定】的信息", notes = "传入json对象进行新增操作")
    public Result insert(@RequestBody PrintBind printBind){        return ResultUtil.success(printBindService.insert(printBind));
    }

    @PutMapping("/printbind/{id}")
    @ApiOperation(value = "修改【打印绑定】的信息", notes = "传入json对象根据id更新【打印绑定】的信息")
    public Result update(@RequestBody PrintBind printBind,@PathVariable("id")Integer id){        printBind.setId(id);
        return ResultUtil.success(printBindService.updateByPrimaryKeySelective(printBind));
    }

    @DeleteMapping("/printbind/{id}")
    @ApiOperation(value = "删除【打印绑定】的信息", notes = "根据id删除【打印绑定】的信息")
    private Result deleteById(@PathVariable("id") Integer id){
        return ResultUtil.success(printBindService.deleteByPrimaryKey(id));
    }

    @DeleteMapping("/printbind/{ids}")
    @ApiOperation(value = "删除【打印绑定】的信息", notes = "根据id删除【打印绑定】的信息")
    private Result deleteByIds(@PathVariable("ids") String ids){
        return ResultUtil.success(printBindService.deleteByKeys(ids));
    }

    @GetMapping("/printbind/list")
    @ApiOperation(value = "分页获取所有【打印绑定】的信息")
    private Result getByPage(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        PageInfo<JsonResult> pageInfo = printBindService.getByPage(pageNum, limit);
        return ResultUtil.success(pageInfo);
    }

    @GetMapping("/printbind/search")
    @ApiOperation(value = "根据条件搜索【打印绑定】的信息", notes = "根据传入的条件来进行搜索")
    private Result searchByCondition(@RequestParam(value = "configId", required = false) Integer configId,
                          @RequestParam(value = "typeId", required = false) Integer typeId,
                          @RequestParam(value = "isEnable", required = false) boolean isEnable,
                          @RequestParam(value = "userId", required = false) Integer userId,
                          @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) throws Exception {
        return ResultUtil.success(printBindService.searchByCondition(configId, typeId, isEnable, userId, pageNum, limit));
    }

}