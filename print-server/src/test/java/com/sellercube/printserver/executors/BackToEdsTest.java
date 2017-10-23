package com.sellercube.printserver.executors;

import com.alibaba.fastjson.JSON;
import com.sellercube.common.entity.Result;
import com.sellercube.printserver.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Chenjing on 2017/10/20.
 *
 * @author Chenjing
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BackToEdsTest {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${eds.url}")
    private String url;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.url.token}")
    private String token;

    @Test
    public void backFbaCode() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        String temp = restTemplate.exchange(dbUrl + "/db/users/" + 1, HttpMethod.GET,
                requestEntity, String.class).getBody();
        System.out.println(temp);
        Result result = JSON.parseObject(temp, Result.class);
        User user = JSON.parseObject(JSON.toJSONString(result.getData()),User.class);
        System.out.println(user.getUsername());
    }

}