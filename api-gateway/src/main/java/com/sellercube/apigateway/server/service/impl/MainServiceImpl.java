package com.sellercube.apigateway.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sellercube.apigateway.server.entity.Monitor;
import com.sellercube.apigateway.server.mapper.MonitorMapper;
import com.sellercube.apigateway.server.service.MainService;
import com.sellercube.apigateway.server.service.PrintBindService;
import com.sellercube.common.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * 跳转到某个服务进行打印
 * Created by Chenjing on 2017/7/14.
 */
@Service
public class MainServiceImpl implements MainService {

    @Autowired
    @Qualifier("apiTemplate")
    private RestTemplate apiTemplate;

    @Autowired
    private MonitorMapper monitorMapper;

    @Autowired
    private PrintBindService printBindService;

    @Override
    public JSONObject process(JSONObject jsonObject) throws Exception {
        //监控表增加记录
        Monitor monitor = new Monitor();
        monitor.setCreateTime(new Date());
        monitor.setStatus("未打印");
        monitorMapper.insertSelective(monitor);
        jsonObject.put("monitorId", monitor.getId());
        //设置请求参数
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", "application/json; charset=UTF-8");
        HttpEntity<String> httpEntity = new HttpEntity<>(jsonObject.toJSONString(), headers);
        //查询可用的IP
        String printType = jsonObject.getString("type").equals("facelist") == true ? "面单" : "标签";
        List<String> ips = printBindService.listByConditon(jsonObject.getString("userid"), printType, true);
        if (null != ips && !ips.isEmpty()) {
            if (ips.size() == 1) {
                //单个ip
                String url = "http://" + ips.get(0) + ":8001/print";
                ResponseEntity<String> responseEntity = apiTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
                return JSONObject.parseObject(responseEntity.getBody());
            } else {
                //多个ip
                ips.forEach(x -> {
                    x = "http://" + x + ":8001/print";
                    apiTemplate.exchange(x, HttpMethod.POST, httpEntity, String.class);
                });
                return (JSONObject) JSON.toJSON(ResultUtil.success("全部打印成功"));
            }
        } else {
            //没有找到ip地址
            return (JSONObject) JSON.toJSON(ResultUtil.error("当前用户没有绑定打印机"));
        }
    }
}
