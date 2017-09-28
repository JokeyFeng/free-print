package com.sellercube.usermanager.server.base.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * Created by Chenjing on 2017/9/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class PrintBindServiceImplTest {
    @Test
    public void insert() throws Exception {
        File dir = new File("/uploadFile");
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

}