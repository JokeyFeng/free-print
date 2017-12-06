package com.sellercube.printserver.utils;

import com.google.common.collect.Lists;
import com.sellercube.common.utils.Base64Util;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

/**
 * 生成文件工具类
 * Created by Chenjing on 2017/7/15.
 *
 * @author Chenjing
 */
@Component
public class FileUtil {


    private static String pdfDir;

    @Value("${pdf.dir}")
    public void setPdfDir(String dir) {
        pdfDir = dir;
    }


    private static final String APPLICATION_PDF = "application/pdf";

    /**
     * @param str    base64 乱码
     * @param suffix 后缀名=文件类型
     * @return 文件路径
     */
    @SuppressWarnings("all")
    public static String base64ToFile(String str, String suffix) throws Exception {
        byte[] bytes = Base64Util.decodeData(str);
        File dir = new File(pdfDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String path = pdfDir + UUID.randomUUID().toString() + "." + suffix;
        @Cleanup FileOutputStream fileOutputStream = new FileOutputStream(path);
        fileOutputStream.write(bytes);
        fileOutputStream.flush();

        return path;
    }

    /**
     * @param url    url路径
     * @param suffix 文件后缀名
     * @return 文件路径
     */
    @SuppressWarnings("all")
    public static String downloadFile(String url, String suffix) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        List<MediaType> list = Lists.newArrayList(MediaType.valueOf(APPLICATION_PDF));
        headers.setAccept(list);
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<byte[]>(headers), byte[].class);
        byte[] result = response.getBody();
        File dir = new File(pdfDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String path = pdfDir + UUID.randomUUID().toString() + "." + suffix;
        @Cleanup FileOutputStream fileOutputStream = new FileOutputStream(path);
        fileOutputStream.write(result);
        fileOutputStream.flush();
        return path;
    }
}
