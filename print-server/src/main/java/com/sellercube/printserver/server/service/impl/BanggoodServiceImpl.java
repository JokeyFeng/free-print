package com.sellercube.printserver.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.server.entity.Monitor;
import com.sellercube.printserver.server.mapper.MonitorMapper;
import com.sellercube.printserver.server.service.BanggoodService;
import com.sellercube.printserver.utils.CoreUtil;
import com.sellercube.printserver.utils.PrintUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Objects;

/**
 * 棒谷接口
 * Created by Chenjing on 2017/7/15.
 */
@Service
public class BanggoodServiceImpl implements BanggoodService {

    @Autowired
    private MonitorMapper monitorMapper;

    @Override
    public Result process(JSONObject jsonObject) throws Exception {
        Integer monitorId = jsonObject.getInteger("monitorId");
        JSONObject data = jsonObject.getJSONObject("Data");
        String pdfUrl = data.getString("PDFUrl");
        String shipType = data.getString("ShipType");

        if (Objects.equals(null, pdfUrl) || Objects.equals("", pdfUrl)) {
            return ResultUtil.error("打印失败，PDFUrl内容为空");
        }
        //还原特殊字符串
        pdfUrl = convert(pdfUrl);
        switch (shipType) {
            case "UPSFedex"://Fedex
                if (pdfUrl.startsWith("iVBORw0KGgo")) {
                    //base64 的图片
                    InputStream inputStream = new ByteArrayInputStream(Base64.decodeBase64(pdfUrl));
                    PrintUtil.printImage(inputStream, "jpg");
                    break;
                }
                //base64 打印机指令
                PrintUtil.printByString(new String(Base64.decodeBase64(pdfUrl)));
                break;
            case "DHL":
                //base64 pdf
                PrintUtil.printPDF(CoreUtil.base64(pdfUrl, "pdf"));
                break;
            case "DPD":
                //base64 的打印机指令
                PrintUtil.printByString(new String(Base64.decodeBase64(pdfUrl)));
                break;
            default:
                Monitor monitor = new Monitor();
                monitor.setId(monitorId);
                monitor.setStatus("打印失败");
                monitor.setId(monitorId);
                monitorMapper.updateByPrimaryKeySelective(monitor);
                return ResultUtil.error("打印失败，不支持" + shipType + "渠道");
        }
        monitorMapper.deleteByPrimaryKey(monitorId);
        return ResultUtil.success("打印成功");
    }

    /**
     * .net那边对特殊字符进行了转换，现在转换过来
     *
     * @param str 字符串
     * @return 原生的数据
     */
    private static String convert(String str) {
        return StringUtils.replace(str, "--jiahao--", "+")
                .replace("--wenhao--", "?")
                .replace("--baifeng--", "%")
                .replace("--jin--", "#")
                .replace("--su--", "/");
    }
}
