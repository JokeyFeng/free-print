package com.sellercube.printserver.rest;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.server.base.service.BaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Chenjing on 2017/6/20.
 */
@RestController
public class BaseController {

    @Autowired
    private BaseService baseService;

    @PostMapping("/print")
    @ApiOperation(value = "打印接口", notes = "根据传入的json对象进行打印")
    private Result handle(@RequestBody JSONObject jsonObject, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("接收到的json"+jsonObject.toString());
        baseService.process(jsonObject,request);
        return ResultUtil.success(null);
    }
}
