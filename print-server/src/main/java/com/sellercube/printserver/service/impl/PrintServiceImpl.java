package com.sellercube.printserver.service.impl;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.entity.Printer;
import com.sellercube.printserver.service.PrintService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.sellercube.printserver.utils.Base64PrintUtil.*;
import static com.sellercube.printserver.entity.PrintMethodConstant.*;

/**
 * Created by Chenjing on 2017/11/10.
 *
 * @author Chenjing
 */
@Service
@Slf4j
public class PrintServiceImpl implements PrintService {

    @Override
    public Result print(Printer param) throws Exception {
        switch (param.getPrintMethod()) {
            case BASE64_PDF:
                base64Pdf(param.getBase64Str());
                break;
            case BASE64_IMG:
                base64Img(param.getBase64Str());
                break;
            case BASE64_CMD:
                base64PrintCmd(param.getBase64Str());
                break;
            default:
                return ResultUtil.error("不支持" + param.getPrintMethod() + "打印方法");
        }
        return ResultUtil.success("打印成功");
    }
}
