package com.sellercube.printserver.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Chenjing on 2017/10/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BanggoodServiceImplTest {
    Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();

    @Test
    public void process() throws Exception {
       /* cache.put("a", "shabi");
        String resultVal = cache.get("jerry", () -> {
            return "a";
        });
        System.out.println(resultVal);*/
    }

}