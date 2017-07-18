package com.sellercube.printserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URLDecoder;
import java.net.URLEncoder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrintServerApplicationTests {

	@Test
	public void contextLoads() throws Exception {
	    String a="http://www.google.com?a=#12&b=???";
        System.out.println("编码："+URLEncoder.encode(a,"utf-8"));
        System.out.println("解码："+URLDecoder.decode(a,"utf-8"));
    }

}
