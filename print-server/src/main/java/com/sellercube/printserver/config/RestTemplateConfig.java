package com.sellercube.printserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Chenjing on 2017/5/26.
 * @author Chenjing
 */
@Configuration
public class RestTemplateConfig {
    @Value("${rest.connection.connect-timeout}")
    private Integer connTimeout;
    @Value("${rest.connection.read-timeout}")
    private Integer readTimeout;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder()
                .setConnectTimeout(connTimeout)
                .setReadTimeout(readTimeout)
                .build();
    }
}
