package com.sellercube.usermanager;

import com.sellercube.common.function.Tuples;
import com.sellercube.usermanager.server.base.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class UserManagerApplicationTests {

    @Autowired
    TestService testService;

    @Test
    public void contextLoads() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String[] strings=new String[]{"A","B"};
        int aaa=Tuples.fnAny(x -> {
            if (Objects.equals("A", x.getT1())) {
                return 3333333;
            }
            return 111111;
        }).apply(strings);
        System.out.println(aaa);

        System.out.println(testService.selectByPrimaryKey("1").toString());
    }

}
