package com.sellercube.printserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.stream.Stream;

/**
 * 启动项目的时候  把以前的文件删除掉
 * Created by Chenjing on 2017/10/23.
 *
 * @author Chenjing
 */
@Component
@Slf4j
public class DeleteFile implements CommandLineRunner {

    @Value("${pdf.dir}")
    private String pdfDir;

    @Override
    public void run(String... strings) {
        log.info("开始检查过期的文件");
        File file = new File(pdfDir);
        boolean isExist = true;
        if (!file.exists()) {
            isExist = file.mkdirs();
        }
        if (isExist) {
            String[] fileList = file.list();
            if (null != fileList) {
                Stream.of(fileList).forEach(x -> {
                    String path = pdfDir + x;
                    File tempFile = new File(path);
                    if (System.currentTimeMillis() > tempFile.lastModified()) {
                        String deleteOperation = tempFile.delete() ? "删除成功" : "删除失败";
                        log.info("删除文件==>>" + tempFile.getName() + "==>>" + deleteOperation);
                    }
                });
            }
        }

    }
}
