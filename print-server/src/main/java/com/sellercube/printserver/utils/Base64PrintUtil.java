package com.sellercube.printserver.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 反射到这个类  进行打印
 * Created by Chenjing on 2017/8/3.
 *
 * @author Chenjing
 */
@Component
public class Base64PrintUtil {
    private static final String IMG_BASE64_START = "iVBORw0KGgo";

    private static final String PDF = "pdf";

    /**
     * 打印base64图片
     */
    public static void base64Img(String var) throws Exception {
        InputStream inputStream = new ByteArrayInputStream(Base64.decodeBase64(var));
        FileUtil.base64ToFile(var, "png");
        PrintUtil.printImage(inputStream, "png");
    }

    /**
     * 打印base64图片
     */
    public static void base64Img(String var, int width, int length, String printType) throws Exception {
        InputStream inputStream = new ByteArrayInputStream(Base64.decodeBase64(var));
        FileUtil.base64ToFile(var, "png");
        PrintUtil.printImage(inputStream, width, length, printType);
    }

    /**
     * 打印base64 pdf
     */
    public static void base64Pdf(String var) throws Exception {
        PrintUtil.printPDF(FileUtil.base64ToFile(var, "pdf"));
    }

    /**
     * 打印base64 打印机指令
     */
    public static void base64PrintCmd(String var) throws Exception {
        PrintUtil.printByString(new String(Base64.decodeBase64(var)));
    }

    /**
     * 打印base64的指令--该方法解决base64PrintCmd方法打印DPD渠道指令调用失败的问题
     */
    public static void base64PrintCommand(String var) throws Exception {
        PrintUtil.printByString(var);
    }

    /**
     * 打印base64的 图片和打印机指令
     */
    public static void base64ImgCmd(String var) throws Exception {
        if (var.startsWith(IMG_BASE64_START)) {
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
    public static void downloadPdf(String var, String suffix) throws Exception {
        if (PDF.equalsIgnoreCase(suffix)) {
            PrintUtil.printPDF(FileUtil.downloadFile(var, suffix));
        } else {
            PrintUtil.printImage(FileUtil.downloadFile(var, suffix));
        }
    }
}
