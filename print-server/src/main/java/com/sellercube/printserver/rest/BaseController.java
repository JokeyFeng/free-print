package com.sellercube.printserver.rest;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;
import com.sellercube.printserver.server.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chenjing on 2017/6/20.
 */
@RestController
public class BaseController {

    @Autowired
    private CoreService coreService;

    @PostMapping("/print")
    public Result handle(@RequestBody JSONObject jsonObject) throws Exception {
        return coreService.print(jsonObject);
    }
}
