package com.sellercube.printserver.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.printserver.entity.PrintParam;
import com.sellercube.printserver.entity.Printer;
import com.sellercube.printserver.service.BanggoodService;
import com.sellercube.printserver.service.PrintService;
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

    public RestfulController() {
    }

    @Autowired
    public RestfulController(BanggoodService var1, PrintService var2) {
        this.banggoodService = var1;
        this.printService = var2;
    }

    private BanggoodService banggoodService;

    private PrintService printService;

    /**
     * 针对棒谷FBA渠道调拨进行打印
     *
     * @param var 打印实体类
     * @return 是否打印成功
     * @throws Exception 异常
     */
    @PostMapping("/bg/fba/print")
    public Result handle(@RequestBody PrintParam var) throws Exception {
        return banggoodService.process(var);
    }

    /**
     * 打印
     *
     * @param var 请求实体类
     * @return 是否打印成功
     */
    @PostMapping(value = "/print")
    public Result print(@RequestBody Printer var) throws Exception {
        return printService.print(var);
    }

}
