package com.sellercube.printserver.utils;

import com.google.common.collect.Lists;
import com.sellercube.common.utils.Base64Util;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.util.List;

/**
 * 生成文件工具类
 * Created by Chenjing on 2017/7/15.
 * @author Chenjing
 */
@Component
public class FileUtil {


    private static final String APPLICATION_PDF = "application/pdf";

    /**
     * @param str    base64 乱码
     * @param suffix 后缀名=文件类型
     * @return 文件路径
     */
    public synchronized static String base64ToFile(String str, String suffix) throws Exception {
        byte[] bytes = Base64Util.decodeData(str);
        String path = "D:/document." + suffix;
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        try {
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
        }
        return path;
    }

    /**
     * @param url    url路径
     * @param suffix 文件后缀名
     * @return 文件路径
     */
    public synchronized static String downloadFile(String url, String suffix) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        List<MediaType> list = Lists.newArrayList(MediaType.valueOf(APPLICATION_PDF));
        headers.setAccept(list);
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<byte[]>(headers), byte[].class);
        byte[] result = response.getBody();
        String path = "D:/document." + suffix;
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        try {
            fileOutputStream.write(result);
            fileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
        }
        return path;
    }
}
