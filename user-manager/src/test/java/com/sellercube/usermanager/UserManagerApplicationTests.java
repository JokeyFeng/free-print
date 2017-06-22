package com.sellercube.usermanager;

import com.sellercube.common.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerApplicationTests {

	@Test
	public void contextLoads() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(MD5Util.encryption("123456"));
	}

}
