package com.sellercube.apigateway;

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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiGatewayApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${db.url}")
    private String url;

    @Value("${db.url.token}")
    private String token;

	@Test
	public void contextLoads() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        String ip = restTemplate.exchange(url + "/db/users/ip?isEnable=1&printType=面单&userId=1",
                HttpMethod.GET, requestEntity, String.class).getBody();
        System.out.println(ip);
    }

}
