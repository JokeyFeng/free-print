package com.sellercube.printserver.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.server.entity.ChannelConfig;
import com.sellercube.printserver.server.entity.Monitor;
import com.sellercube.printserver.server.mapper.MonitorMapper;
import com.sellercube.printserver.server.service.BanggoodService;
import com.sellercube.printserver.server.service.ChannelConfigService;
import com.sellercube.printserver.utils.CoreUtil;
import com.sellercube.printserver.utils.PrintUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 棒谷接口
 * Created by Chenjing on 2017/7/15.
 */
@Service
public class BanggoodServiceImpl implements BanggoodService {

    @Autowired
    private MonitorMapper monitorMapper;

    @Autowired
    private ChannelConfigService channelConfigService;

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
        ChannelConfig channelConfig = channelConfigService.selectByChannelName(shipType);
        Objects.requireNonNull(channelConfig, "不支持" + shipType + "渠道");

        //反射执行方法
        Class<?> clazz = Class.forName(channelConfig.getClazz());
        Method method = clazz.getMethod(channelConfig.getMethod(), String.class);
        Object object = clazz.newInstance();
        method.invoke(object, pdfUrl);
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
