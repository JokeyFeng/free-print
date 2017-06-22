package com.sellercube.printserver.rest;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chenjing on 2017/6/20.
 */
@RestController
public class BaseController {

    @PostMapping("/print")
    @ApiOperation(value = "打印接口", notes = "根据传入的json对象进行打印")
    private Result handle(@RequestBody JSONObject jsonObject){
        return null;
    }
}
