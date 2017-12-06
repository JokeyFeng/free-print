package com.sellercube.printserver.executors;

import com.google.common.collect.ImmutableMap;
import com.sellercube.printserver.http.RestRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

/**
 * 数据回传到EDS
 * Created by Chenjing on 2017/10/20.
 *
 * @author Chenjing
 */
@Component
@Slf4j
public class BackToEds {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${eds.url}")
    private String url;

    @Value("${process.center.id:0}")
    private String processCenterId;

    /**
     * 打印成功回传FBA单号给EDS
     *
     * @param fbaCode fba单号
     * @param userId  用户id
     */
    @SuppressWarnings("all")
    @Async
    public void backFbaCode(String fbaCode, String userId) {
        RestRequest restRequest = new RestRequest(restTemplate);
        if (Objects.equals("0", processCenterId)) {
            //国内
            Map<String, ?> param = ImmutableMap.of("ProductShiftBoxCodes", fbaCode, "UserName", userId);
            log.info(fbaCode + "=>" + restRequest.get(url, param, String.class, null));
        } else {
            //国外
            Map<String, ?> param = ImmutableMap.of("ProductShiftBoxCodes", fbaCode, "UserName", userId, "ProcessCenterID", processCenterId);
            log.info(fbaCode + "=>" + restRequest.get(url, param, String.class, null));
        }

    }
}
