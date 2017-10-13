package com.sellercube.printserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.sellercube.common.entity.ChannelConfig;
import com.sellercube.common.entity.PrintParam;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.service.BanggoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 棒谷接口
 * Created by Chenjing on 2017/7/15.
 */
@Service
public class BanggoodServiceImpl implements BanggoodService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${db.url}")
    private String url;

    @Value("${db.url.token}")
    private String token;

    @Override
    public Result process(PrintParam printParam) throws Exception {
        String pdfUrl = printParam.getContent();
        String shipType = printParam.getShipType();
        Objects.requireNonNull(shipType, "棒谷渠道shipType为null");
        if (Objects.equals(null, pdfUrl) || Objects.equals("", pdfUrl)) {
            return ResultUtil.error("打印失败，PDFUrl内容为空");
        }

        //还原特殊字符串
        pdfUrl = this.convertStr(pdfUrl);
        //请求数据库接口查询
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        String result = restTemplate.exchange(url + "/db/channel?channelName=" + shipType,
                HttpMethod.GET, requestEntity, String.class).getBody();

        Result jsonResult = JSON.parseObject(result, Result.class);
        ChannelConfig channelConfig;
        if (Objects.equals(200, jsonResult.getCode())) {
            channelConfig = JSON.parseObject(JSON.toJSONString(jsonResult.getData()), ChannelConfig.class);
        } else {
            throw new Exception(jsonResult.getData().toString());
        }

        Objects.requireNonNull(channelConfig, "不支持" + shipType + "渠道");

        //反射执行方法
        Class<?> clazz = Class.forName(channelConfig.getClazz());
        Method method = clazz.getMethod(channelConfig.getMethod(), String.class);
        Object object = clazz.newInstance();
        method.invoke(object, pdfUrl);
        return ResultUtil.success("打印成功");
    }

    /**
     * .net那边对特殊字符进行了转换，现在转换过来
     *
     * @param str 字符串
     * @return 原生的数据
     */
    private String convertStr(String str) {
        return StringUtils.replace(str, "--jiahao--", "+")
                .replace("--wenhao--", "?")
                .replace("--baifeng--", "%")
                .replace("--jin--", "#")
                .replace("--su--", "/");
    }
}