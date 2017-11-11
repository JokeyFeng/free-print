package com.sellercube.usermanager.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.usermanager.server.base.service.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chenjing on 2017/11/7.
 *
 * @author Chenjing
 */
@RestController
@Api(tags = "仓库")
public class StorageController {

    private StorageService storageService;

    public StorageController() {
    }

    @Autowired
    public StorageController(StorageService var) {
        this.storageService = var;
    }

    @GetMapping("/storages")
    @ApiOperation(value = "获取所有的仓库")
    public Result get(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                      @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        return ResultUtil.success(storageService.list(pageNum, limit));
    }

    @GetMapping("/storage/search")
    @ApiOperation(value = "根据仓库名进行搜索")
    public Result search(@RequestParam(value = "storageName") String storageName,
                         @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        return ResultUtil.success(storageService.search(storageName, pageNum, limit));
    }
}
