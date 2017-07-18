package com.sellercube.printserver.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.server.service.BanggoodService;
import com.sellercube.printserver.utils.CoreUtil;
import com.sellercube.printserver.utils.PrintUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * 棒谷接口
 * Created by Chenjing on 2017/7/15.
 */
@Service
public class BanggoodServiceImpl implements BanggoodService {
    @Override
    public Result process(JSONObject jsonObject) throws Exception {
        JSONObject data = jsonObject.getJSONObject("Data");
        String pdfUrl = data.getString("PDFUrl");
        String shipType = data.getString("ShipType");

        if (Objects.equals(null, pdfUrl) || Objects.equals("", pdfUrl)) {
            return ResultUtil.error("打印失败，获取不到pdf的url");
        }
        pdfUrl = convert(pdfUrl);
        switch (shipType) {
            case "UPSFedex"://Fedex
                PrintUtil.printByString(new String(Base64.decodeBase64(pdfUrl)));
                break;
            case "DHL":
                PrintUtil.printPDF(CoreUtil.base64(pdfUrl, "pdf"));
                break;
            case "DPD":
                PrintUtil.printByString(new String(Base64.decodeBase64(pdfUrl)));
                return ResultUtil.error("抱歉，目前DPD渠道fds那边还未更新，所以不能打印");
            default:
                return ResultUtil.error("打印失败，不支持该渠道");
        }

        return ResultUtil.success("打印成功");
    }

    /**
     * .net那边对字符串进行了转换，现在转换过来
     *
     * @param str 字符串
     * @return 原生的base64
     */
    private static String convert(String str) {
        return StringUtils.replace(str, "--jiahao--", "+")
                .replace("--wenhao--", "?")
                .replace("--baifeng--", "%")
                .replace("--jin--", "#")
                .replace("--su--", "/");
    }
}
