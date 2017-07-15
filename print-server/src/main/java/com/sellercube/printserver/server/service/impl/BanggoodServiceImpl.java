package com.sellercube.printserver.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.server.service.BanggoodService;
import com.sellercube.printserver.utils.CoreUtil;
import com.sellercube.printserver.utils.PrintUtil;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 *
 * Created by Chenjing on 2017/7/15.
 */
@Service
public class BanggoodServiceImpl implements BanggoodService {
    @Override
    public Result process(JSONObject jsonObject) throws Exception {
        String pdfUrl = jsonObject.getString("PDFUrl");
        String path = null;
        if (Objects.equals(null, pdfUrl)) {
            return ResultUtil.error("打印失败");
        }

        if (pdfUrl.startsWith("http")) {
            //如果是http
            path = CoreUtil.download(pdfUrl, "pdf");
        } else if (pdfUrl.length() > 500) {
            //如果是base64
            path = CoreUtil.base64(pdfUrl, "pdf");
        }

        if (!Objects.equals(null, path) && !Objects.equals("", path)) {
            PrintUtil.printPDF(path);
            return ResultUtil.success("打印成功");
        }
        return ResultUtil.error("打印失败");
    }
}
