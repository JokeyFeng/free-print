package com.sellercube.printserver.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.printserver.entity.PrintParam;
import com.sellercube.printserver.service.BanggoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 唯一开放的控制层
 * Created by Chenjing on 2017/6/20.
 *
 * @author Chenjing
 */
@RestController
public class RestfulController {

    @Autowired
    private BanggoodService banggoodService;

    /**
     * 针对棒谷FBA渠道调拨进行打印
     *
     * @param var
     * @return
     * @throws Exception
     */
    @PostMapping("/bg/fba/print")
    public Result handle(@RequestBody PrintParam var) throws Exception {
        return banggoodService.process(var);
    }
}
