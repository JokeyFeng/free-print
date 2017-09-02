package com.sellercube.printserver.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.server.service.FlytService;
import com.sellercube.printserver.utils.CoreUtil;
import com.sellercube.printserver.utils.PrintUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 飞特接口
 * Created by Chenjing on 2017/7/15.
 */
@Service
public class FlytServiceImpl implements FlytService {

    @Override
    public Result process(JSONObject jsonObject) throws Exception {
        String path;
        Result result;
        JSONObject data = jsonObject.getJSONObject("Data");
        switch (data.getString("Format")) {
            case "PDF":
                path = CoreUtil.base64(data.getString("Label"), "pdf");
                result = validate(path, true);
                break;
            case "PNG":
                path = CoreUtil.base64(data.getString("Label"), "png");
                result = validate(path, true);
                break;
            case "EPL":
                PrintUtil.printByString(new String(Base64.decodeBase64(data.getString("Label"))));
                result = validate(null, false);
                break;
            default:
                return ResultUtil.error("打印失败,不支持" + data.getString("Format") + "格式");
        }
        return result;

    }

    /**
     * 验证有没有正确生成文件
     *
     * @param path      文件路径
     * @param isValid   需不需要验证
     */
    private Result validate(String path, boolean isValid) throws Exception {
        if (isValid) {
            //需要验证生成文件
            if (!Objects.equals(null, path) && !Objects.equals("", path)) {
                PrintUtil.printPDF(path);
                return ResultUtil.success("打印成功");
            } else {
                return ResultUtil.error("打印失败，没有正确生成文件");
            }
        } else {
            //不需要验证有没有文件
            return ResultUtil.success("打印成功");
        }
    }
}
