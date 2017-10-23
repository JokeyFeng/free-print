package com.sellercube.apigateway.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableMap;
import com.sellercube.apigateway.entity.PrintTypeEnum;
import com.sellercube.apigateway.service.MainService;
import com.sellercube.common.entity.HttpStatus;
import com.sellercube.common.entity.PrintParam;
import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 跳转到某个服务进行打印
 * Created by Chenjing on 2017/7/14.
 */
@Service
public class MainServiceImpl implements MainService {

    private static final Logger log = LoggerFactory.getLogger(MainServiceImpl.class);

    private static Cache<String, List<String>> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterAccess(1, TimeUnit.HOURS)
            .build();

    @Autowired
    private RestTemplate restTemplate;

    @Value("${db.url}")
    private String url;

    @Value("${db.url.token}")
    private String token;

    private static final Map<String, PrintTypeEnum> PRINT_TYPE_ENUM_MAP =
            ImmutableMap.of("facelist", PrintTypeEnum.FACELIST, "label", PrintTypeEnum.LABEL);


    @Override
    @SuppressWarnings("unchecked")
    public Result process(JSONObject jsonObject) throws Exception {
        //转换参数
        PrintParam printParam = this.setParam(jsonObject);
        String printType = printParam.getPrintType();
        String userId = printParam.getUserId();
        //在缓存查看用户绑定的IP
        List<String> ipList = cache.get(userId + printType, () -> {
            //请求数据库接口查询可用的IP
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", token);
            HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
            String result = restTemplate.exchange(url + "/db/users/ip?isEnable=1&printType=" + printType + "&userId=" + userId,
                    HttpMethod.GET, requestEntity, String.class).getBody();
            Result jsonResult = JSON.parseObject(result, Result.class);
            if (Objects.equals(HttpStatus.SUCCESS.getCode(), jsonResult.getCode())) {
                log.info("user bind ips=>{}", jsonResult.getData());
                return (List<String>) jsonResult.getData();
            } else {
                throw new Exception(jsonResult.getData().toString());
            }
        });

        if (!ipList.isEmpty()) {
            //设置请求头参数
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", "application/json; charset=UTF-8");
            HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(printParam), headers);

            if (ipList.size() == 1) {
                //单个ip
                String url = "http://" + ipList.get(0) + ":8001/print";
                String response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class).getBody();
                return JSON.parseObject(response, Result.class);
            } else {
                //多个ip
                ipList.forEach(x -> {
                    String url = "http://" + x + ":8001/print";
                    restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
                });
                return ResultUtil.success(ipList.size() + "台打印机全部打印成功");
            }
        } else {
            //没有找到ip地址
            cache.invalidate(userId + printType + "1");
            return ResultUtil.error("当前用户没有绑定打印机");
        }
    }

    /**
     * 转化包装请求的参数
     */
    private PrintParam setParam(JSONObject jsonObject) throws Exception {
        PrintParam param = new PrintParam();
        param.setFrom(jsonObject.getString("from"));
        param.setUserId(jsonObject.getString("userid"));
        param.setPrintType(PRINT_TYPE_ENUM_MAP.get(jsonObject.getString("type")).getChinesName());
        JSONObject data = jsonObject.getJSONObject("Data");
        //重要：设置打印的内容
        switch (param.getFrom()) {
            case "bg":
                param.setContent(data.getString("PDFUrl"));
                break;
            case "ft":
                param.setContent(data.getString("Label"));
                break;
            default:
                throw new Exception("转换内容参数异常,from字段缺失");
        }
        param.setFormat(data.getString("Format"));
        param.setShipType(data.getString("ShipType"));
        param.setFbaCode(data.getString("FBACode"));
        return param;
    }
}
