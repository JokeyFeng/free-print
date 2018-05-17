package com.sellercube.printserver.rest;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.entity.IbnBox;
import com.sellercube.printserver.entity.OpenBox;
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
     * @param printParam 打印实体类
     * @return 是否打印成功
     * @throws Exception 异常
     */
    @PostMapping("/bg/fba/print")
    public Result handle(@RequestBody PrintParam printParam) throws Exception {
        return ResultUtil.success(banggoodService.process(printParam));
    }

    /**
     * 打印
     *
     * @param printer 请求实体类
     * @return 是否打印成功
     * @throws Exception 异常
     */
    @PostMapping(value = "/print")
    public Result print(@RequestBody Printer printer) throws Exception {
        return ResultUtil.success(printService.print(printer));
    }

    /**
     * 打印项目提供的模板
     *
     * @param openBox 开箱入库实体类
     * @return 打印是否成
     * @throws Exception 异常
     */
    @PostMapping(value = "/print/model")
    public Result printModel(@RequestBody OpenBox openBox) throws Exception {
        return ResultUtil.success(printService.printModel(openBox));
    }

    /**
     * 打印手持提供的IBN信息
     * @param ibnBox
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/print/binCode")
    public Result printBinBox(@RequestBody IbnBox ibnBox) throws Exception {
        return ResultUtil.success(printService.printModel(ibnBox));
    }
    
    @GetMapping(value = "/test/print")
    public Result testMethod() {
        return ResultUtil.success("Welcome to Use Print Method!");
    }
}
