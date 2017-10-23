package com.sellercube.printserver.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 反射到这个类  进行打印
 * Created by Chenjing on 2017/8/3.
 * @author Chenjing
 */
public class ChannelUtil {
    private final String imgBase64Start="iVBORw0KGgo";
    /**
     * 打印base64图片
     */
    public void base64Img(String var) throws Exception {
        InputStream inputStream = new ByteArrayInputStream(Base64.decodeBase64(var));
        PrintUtil.printImage(inputStream, "jpg");
    }

    /**
     * 打印base64 pdf
     */
    public void base64Pdf(String var) throws Exception {
        PrintUtil.printPDF(FileUtil.base64ToFile(var, "pdf"));
    }

    /**
     * 打印base64 打印机指令
     */
    public void base64PrintCmd(String var) throws Exception {
        PrintUtil.printByString(new String(Base64.decodeBase64(var)));
    }

    /**
     * 打印base64的 图片和打印机指令
     */
    public void base64ImgCmd(String var) throws Exception {
        if (var.startsWith(imgBase64Start)) {
            //base64 的图片
            InputStream inputStream = new ByteArrayInputStream(Base64.decodeBase64(var));
            PrintUtil.printImage(inputStream, "jpg");
            return;
        }
        //base64 打印机指令
        PrintUtil.printByString(new String(Base64.decodeBase64(var)));
    }

    /**
     * 打印下载的pdf文件
     */
    public void downloadPdf(String var) throws Exception {
        PrintUtil.printPDF(FileUtil.downloadFile(var, "pdf"));
    }
}
