package com.sellercube.printserver.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.server.service.FlytService;
import com.sellercube.printserver.utils.CoreUtil;
import com.sellercube.printserver.utils.PrintUtil;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 *飞特接口
 * Created by Chenjing on 2017/7/15.
 */
@Service
public class FlytServiceImpl implements FlytService {
    @Override
    public Result process(JSONObject jsonObject) throws Exception {
        String path = null;
        JSONObject data = jsonObject.getJSONObject("Data");
        switch (data.getString("Format")) {
            case "PDF":
                path = CoreUtil.base64(data.getString("Label"), "pdf");
                break;
            case "PNG":
                path = CoreUtil.base64(data.getString("Label"), "png");
                break;
            default:
                break;
        }

        if (!Objects.equals(null, path) && !Objects.equals("", path)) {
            PrintUtil.printPDF(path);
            return ResultUtil.success("打印成功");
        }

        return ResultUtil.error("打印失败");
    }
}
