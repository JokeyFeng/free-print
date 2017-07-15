package com.sellercube.printserver.utils;

import com.google.common.collect.Lists;
import com.sellercube.common.utils.Base64Util;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

/**
 * 生成文件工具类
 * Created by Chenjing on 2017/7/15.
 */
@Component
public class CoreUtil {


    private static final String APPLICATION_PDF = "application/pdf";

    /**
     * @param str    base64 乱码
     * @param suffix 后缀名=文件类型
     * @return 文件路径
     */
    public static String base64(String str, String suffix) throws Exception {
        String uuid = UUID.randomUUID().toString();
        byte[] bytes = Base64Util.decodeData(str);
        String path = "D:/" + uuid + "." + suffix;
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
        return path;
    }

    /**
     * @param url url路径
     * @param suffix 文件后缀名
     * @return 文件路径
     */
    public static String download(String url, String suffix) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String uuid = UUID.randomUUID().toString();
        HttpHeaders headers = new HttpHeaders();
        List<MediaType> list = Lists.newArrayList(MediaType.valueOf(APPLICATION_PDF));
        headers.setAccept(list);
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<byte[]>(headers), byte[].class);
        byte[] result = response.getBody();
        String path = "D:/" + uuid + "." + suffix;
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        fileOutputStream.write(result);
        fileOutputStream.flush();
        fileOutputStream.close();
        return path;
    }
}
