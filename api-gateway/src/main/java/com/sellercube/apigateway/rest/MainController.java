package com.sellercube.apigateway.rest;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.apigateway.service.MainService;
import com.sellercube.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chenjing on 2017/7/13.
 */
@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @PostMapping(value = "/print")
    public Result a(@RequestBody JSONObject jsonObject) throws Exception {
        return mainService.process(jsonObject);
    }
}
