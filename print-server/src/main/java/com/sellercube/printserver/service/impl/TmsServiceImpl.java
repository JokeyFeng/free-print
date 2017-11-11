package com.sellercube.printserver.service.impl;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.entity.PrintReqBody;
import com.sellercube.printserver.service.TmsService;
import com.sellercube.printserver.utils.FileUtil;
import com.sellercube.printserver.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by Chenjing on 2017/11/10.
 *
 * @author Chenjing
 */
@Service
@Slf4j
public class TmsServiceImpl implements TmsService {

    @Override
    public Result print(PrintReqBody printReqBody) throws Exception {
        String path = FileUtil.base64ToFile(printReqBody.getFileStream(), "pdf");
        PrintUtil.printPDF(path);
        return ResultUtil.success("打印成功");
    }
}
