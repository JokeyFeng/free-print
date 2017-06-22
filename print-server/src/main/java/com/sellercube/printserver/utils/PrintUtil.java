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
import java.io.IOException;

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
    public static void printByString(String str) {
        // 构建打印请求属性集
        HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        // 设置打印格式，因为未确定类型，所以选择autosense
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        // 定位默认的打印服务
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        try {
            DocPrintJob job = defaultService.createPrintJob(); // 创建打印作业
            DocAttributeSet das = new HashDocAttributeSet();
            Doc doc = new SimpleDoc(str.getBytes(), flavor, das);
            job.print(doc, pras);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印图片 支持gif jpg png 三种格式
     *
     * @param fileName 文件路径
     * @param width    宽度
     * @param height   高度
     */
    public static void printImage(String fileName, Integer width, Integer height) {
        try {
            DocFlavor dof = null;
            if (fileName.endsWith(".gif")) {
                dof = DocFlavor.INPUT_STREAM.GIF;
            } else if (fileName.endsWith(".jpg")) {
                dof = DocFlavor.INPUT_STREAM.JPEG;
            } else if (fileName.endsWith(".png")) {
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
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (PrintException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * 打印图片 支持gif jpg png 默认宽度高度 10X15
     *
     * @param fileName 文件路径
     */
    public static void printImage(String fileName) {
        printImage(fileName, 100, 150);
    }

    /**
     * 打印图片
     *
     * @param fileInputStream 图片的输入流
     * @param width           宽度
     * @param height          高度
     * @param type            图片的格式
     */
    public static void printImage(FileInputStream fileInputStream, Integer width, Integer height, String type) {
        try {
            DocFlavor dof = null;
            if (type.endsWith(".gif")) {
                dof = DocFlavor.INPUT_STREAM.GIF;
            } else if (type.endsWith(".jpg")) {
                dof = DocFlavor.INPUT_STREAM.JPEG;
            } else if (type.endsWith(".png")) {
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
            FileInputStream fin = fileInputStream;
            Doc doc = new SimpleDoc(fin, dof, das);
            DocPrintJob job = ps.createPrintJob();
            job.print(doc, pras);
            fin.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (PrintException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * 打印图片 默认10X15
     *
     * @param fileInputStream 输入流
     * @param type            图片的格式
     */
    public static void printImage(FileInputStream fileInputStream, String type) {
        printImage(fileInputStream, 100, 150, type);
    }
}
