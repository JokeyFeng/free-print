package com.sellercube.printserver.server.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sellercube.printserver.server.base.service.BaseService;
import com.sellercube.printserver.utils.PrintUtil;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Chenjing on 2017/6/30.
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Override
    public void process(JSONObject jsonObject, HttpServletRequest request) throws Exception {
        String type = jsonObject.getString("type");
        switch (type) {
            case "string":
                PrintUtil.printByString(jsonObject.getString("data"));
                break;
            case "image":
                PrintUtil.printImage(inputStream(jsonObject.getString("url")), jsonObject.getString("suffix"));
                break;
            case "url":
                PrintUtil.printPDF("D:/" + download(jsonObject.getString("url")) + ".pdf");
                break;
        }
    }

    private String download(String url) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        final String APPLICATION_PDF = "application/pdf";
        HttpHeaders headers = new HttpHeaders();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String uuid = UUID.randomUUID().toString();
        try {
            List list = new ArrayList<>();
            list.add(MediaType.valueOf(APPLICATION_PDF));
            headers.setAccept(list);

            ResponseEntity<byte[]> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<byte[]>(headers),
                    byte[].class);

            byte[] result = response.getBody();

            inputStream = new ByteArrayInputStream(result);

            File file = new File("D:/" + uuid + ".pdf");
            if (!file.exists()) {
                file.createNewFile();
            }

            outputStream = new FileOutputStream(file);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = inputStream.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
        return uuid;
    }

    private InputStream inputStream(String url) {
        RestTemplate restTemplate = new RestTemplate();

        final String APPLICATION_PDF = "application/pdf";
        HttpHeaders headers = new HttpHeaders();
        String uuid = UUID.randomUUID().toString();
        List list = new ArrayList<>();
        list.add(MediaType.valueOf(APPLICATION_PDF));
        headers.setAccept(list);

        ResponseEntity<byte[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<byte[]>(headers),
                byte[].class);

        byte[] result = response.getBody();
        return new ByteArrayInputStream(result);
    }
}
