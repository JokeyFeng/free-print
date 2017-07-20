package com.sellercube.printserver.utils;

import org.springframework.stereotype.Component;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.PrintQuality;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 打印工具类
 * Created by Chenjing on 2017/6/22.
 */
@Component
public class PrintUtil {

    /**
     * 把渠道商返回的字符串进行打印
     *
     * @param str 渠道给的一堆文字
     */
    public static void printByString(String str) throws Exception {
        // 构建打印请求属性集
        HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        // 设置打印格式，因为未确定类型，所以选择autosense
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        // 定位默认的打印服务
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob job = defaultService.createPrintJob(); // 创建打印作业
        DocAttributeSet das = new HashDocAttributeSet();
        Doc doc = new SimpleDoc(str.getBytes(), flavor, das);
        job.print(doc, pras);
    }

    /**
     * 打印图片 支持gif jpg png 三种格式
     *
     * @param fileName 文件路径
     * @param width    宽度 mm
     * @param height   高度 mm
     */
    public static void printImage(String fileName, Integer width, Integer height) throws Exception {
        DocFlavor dof = null;
        if (fileName.toLowerCase().endsWith("gif")) {
            dof = DocFlavor.INPUT_STREAM.GIF;
        } else if (fileName.toLowerCase().endsWith("jpg")) {
            dof = DocFlavor.INPUT_STREAM.JPEG;
        } else if (fileName.toLowerCase().endsWith("png")) {
            dof = DocFlavor.INPUT_STREAM.PNG;
        }
        PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(OrientationRequested.PORTRAIT);
        pras.add(new Copies(1));
        pras.add(PrintQuality.HIGH);
        DocAttributeSet das = new HashDocAttributeSet();
        // 设置打印纸张的大小（以毫米为单位）
        das.add(new MediaPrintableArea(0, 0, width, height, MediaPrintableArea.MM));
        FileInputStream fin = new FileInputStream(fileName);
        Doc doc = new SimpleDoc(fin, dof, das);
        DocPrintJob job = ps.createPrintJob();
        job.print(doc, pras);
        fin.close();
    }

    /**
     * 打印图片 支持gif jpg png 默认宽度高度 100X150
     *
     * @param fileName 文件路径
     */
    public static void printImage(String fileName) throws Exception {
        printImage(fileName, 100, 150);
    }

    /**
     * 打印图片
     *
     * @param inputStream 图片的输入流
     * @param width           宽度 mm
     * @param height          高度 mm
     * @param type            图片的格式
     */
    public static void printImage(InputStream inputStream, Integer width, Integer height, String type) throws Exception {
        DocFlavor dof = null;
        if (type.toLowerCase().equals("gif")) {
            dof = DocFlavor.INPUT_STREAM.GIF;
        } else if (type.toLowerCase().endsWith("jpg")) {
            dof = DocFlavor.INPUT_STREAM.JPEG;
        } else if (type.toLowerCase().endsWith("png")) {
            dof = DocFlavor.INPUT_STREAM.PNG;
        }
        PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(OrientationRequested.PORTRAIT);
        pras.add(new Copies(1));
        pras.add(PrintQuality.HIGH);
        DocAttributeSet das = new HashDocAttributeSet();
        // 设置打印纸张的大小（以毫米为单位）
        das.add(new MediaPrintableArea(0, 0, width, height, MediaPrintableArea.MM));
        Doc doc = new SimpleDoc(inputStream, dof, das);
        DocPrintJob job = ps.createPrintJob();
        job.print(doc, pras);
        inputStream.close();
    }

    /**
     * 打印图片 默认100X150
     *
     * @param inputStream 输入流
     * @param type            图片的格式
     */
    public static void printImage(InputStream inputStream, String type) throws Exception {
        printImage(inputStream, 100, 150, type);
    }

    /**
     * 打印PDF 电脑需要安装Adobe Acrobat Reader DC
     *
     * @param path pdf路径
     */
    public static void printPDF(String path) throws Exception {
        Runtime.getRuntime().exec("cmd.exe /C start acrord32 /P /h " + path);
    }
}
