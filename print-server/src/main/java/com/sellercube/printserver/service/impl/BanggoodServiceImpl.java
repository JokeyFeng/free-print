package com.sellercube.printserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableMap;
import com.sellercube.common.entity.HttpStatus;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import com.sellercube.printserver.entity.ChannelConfig;
import com.sellercube.printserver.entity.DotNetFba;
import com.sellercube.printserver.entity.PrintParam;
import com.sellercube.printserver.executors.BackToEds;
import com.sellercube.printserver.http.RestRequest;
import com.sellercube.printserver.service.BanggoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 棒谷接口
 * Created by Chenjing on 2017/7/15.
 *
 * @author Chenjing
 */
@Service
@Slf4j
public class BanggoodServiceImpl implements BanggoodService {

    private static Cache<String, ChannelConfig> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterAccess(8, TimeUnit.HOURS)
            .build();

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BackToEds backToEds;

    @Value("${db.url}")
    private String url;

    @Value("${db.url.token}")
    private String token;

    @Override
    public Result process(PrintParam printParam) throws Exception {
        DotNetFba dotnetFba = printParam.getData();
        String pdfUrl = dotnetFba.getPdfUrl();
        String shipType = dotnetFba.getShipType();
        Objects.requireNonNull(shipType, "棒谷渠道shipType为null");
        if (Objects.equals(null, pdfUrl) || Objects.equals("", pdfUrl)) {
            return ResultUtil.error("打印失败，PDFUrl内容为空");
        }

        //还原特殊字符串
        pdfUrl = this.convertStr(pdfUrl);

        //从缓存中获取打印的方法
        ChannelConfig channelConfig = cache.get(shipType, () -> {
            RestRequest restRequest = new RestRequest(restTemplate);
            //请求数据库接口查询
            Map<String, ?> param = ImmutableMap.of("channelName", shipType);
            Map<String, String> header = ImmutableMap.of("Authorization", token);
            String result = restRequest.get(url + "/db/channel", param, String.class, header).getBody();
            Result jsonResult = JSON.parseObject(result, Result.class);
            if (Objects.equals(HttpStatus.SUCCESS.getCode(), jsonResult.getCode())) {
                ChannelConfig channelConfig1 = JSON.parseObject(JSON.toJSONString(jsonResult.getData()), ChannelConfig.class);
                if (channelConfig1 == null) {
                    throw new Exception("不支持" + shipType + "渠道打印");
                }
                return channelConfig1;
            } else {
                throw new Exception(jsonResult.getData().toString());
            }
        });

        //反射执行方法
        Class<?> clazz = Class.forName(channelConfig.getClazz());
        Method method = clazz.getMethod(channelConfig.getMethod(), String.class);
        Object object = clazz.newInstance();
        method.invoke(object, pdfUrl);
        backToEds.backFbaCode(dotnetFba.getFbaCode(), printParam.getUserId());
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