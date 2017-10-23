package com.sellercube.printserver.service.impl;

import com.sellercube.common.entity.PrintParam;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.Base64Util;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.service.FlytService;
import com.sellercube.printserver.utils.FileUtil;
import com.sellercube.printserver.utils.PrintUtil;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.Objects;

/**
 * 飞特接口
 * Created by Chenjing on 2017/7/15.
 * @author Chenjing
 */
@Service
public class FlytServiceImpl implements FlytService {

    @Override
    public Result process(PrintParam printParam) throws Exception {
        String format = printParam.getFormat();
        Objects.requireNonNull(format, "飞特打印格式为null");
        switch (format) {
            case "PDF":
                String path = FileUtil.base64ToFile(printParam.getContent(), "pdf");
                PrintUtil.printPDF(path);
                break;
            case "PNG":
                PrintUtil.printImage(new ByteArrayInputStream(Base64Util.decodeData(printParam.getContent())), "png");
                break;
            case "EPL":
                PrintUtil.printByString(new String(Base64Util.decodeData(printParam.getContent())));
                break;
            default:
                return ResultUtil.error("打印失败,不支持" + printParam.getFormat() + "格式");
        }
        return ResultUtil.success("打印成功");

    }
}

