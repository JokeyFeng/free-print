package com.sellercube.printserver.executors;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableMap;
import com.sellercube.common.entity.Result;
import com.sellercube.printserver.entity.User;
import com.sellercube.printserver.http.RestRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 数据回传到EDS
 * Created by Chenjing on 2017/10/20.
 *
 * @author Chenjing
 */
@Component
@Slf4j
public class BackToEds {

    private static Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(10000)
            .expireAfterAccess(10, TimeUnit.HOURS)
            .build();
    @Autowired
    private RestTemplate restTemplate;

    @Value("${eds.url}")
    private String url;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.url.token}")
    private String token;

    /**
     * 打印成功回传FBA单号给EDS
     *
     * @param fbaCode fba单号
     * @param userId  用户id
     * @throws ExecutionException 缓存异常
     */
    @Async
    public void backFbaCode(String fbaCode, String userId) throws ExecutionException {
        RestRequest restRequest = new RestRequest(restTemplate);
        //从缓存获取用户名
        String userName = cache.get(userId, () -> {
            //从接口请求用户名缓存
            Map<String, String> header = ImmutableMap.of("Authorization", token);
            String body = restRequest.get(dbUrl + "/db/users/" + userId, null, String.class, header).getBody();
            Result result = JSON.parseObject(body, Result.class);
            User user = JSON.parseObject(JSON.toJSONString(result.getData()), User.class);
            return user.getUsername();
        });
        Map<String, ?> param = ImmutableMap.of("ProductShiftBoxCodes", fbaCode, "UserName", userName);
        log.info(fbaCode + "=>" + restRequest.get(url + "/api/ProductShift/ExecutePrint", param, String.class, null));
    }
}
