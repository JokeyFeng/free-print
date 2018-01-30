package com.sellercube.printserver.entity;

import com.google.common.collect.Maps;
import com.sellercube.printserver.utils.Base64PrintUtil;

import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by Chenjing on 2018/1/24.
 *
 * @author Chenjing
 */
public final class LocalMap {

    public static Map<String, Consumer<String>> channelPrintMap = Maps.newConcurrentMap();

    private static final String HTTP = "http";

    static {
        channelPrintMap.put("Fedex", x -> {
            try {
                Base64PrintUtil.base64ImgCmd(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        channelPrintMap.put("DHL", x -> {
            try {
                Base64PrintUtil.base64Pdf(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        channelPrintMap.put("DPD", x -> {
            try {
                Base64PrintUtil.base64PrintCmd(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        channelPrintMap.put("加拿大UPS", x -> {
            try {
                if (x.startsWith(HTTP)) {
                    //下载文件进行打印
                    Base64PrintUtil.downloadPdf(x, "jpg");
                } else {
                    //base64 PDF
                    Base64PrintUtil.base64Pdf(x);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
