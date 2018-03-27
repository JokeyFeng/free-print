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

        channelPrintMap.put("Fedex空派", x -> {
            try {
                Base64PrintUtil.base64ImgCmd(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        channelPrintMap.put("Fedex一票多件", x -> {
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

        channelPrintMap.put("DHL空派", x -> {
            try {
                Base64PrintUtil.base64Pdf(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        channelPrintMap.put("DHL一票多件", x -> {
            try {
                Base64PrintUtil.base64Pdf(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        channelPrintMap.put("DPD", x -> {
            try {
                Base64PrintUtil.base64ImgCmd(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        channelPrintMap.put("DPD一票多件", x -> {
                    try {
                        Base64PrintUtil.base64PrintCommand(x);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
        });
        channelPrintMap.put("DPD空派", x -> {
                    try {
                        Base64PrintUtil.base64PrintCommand(x);
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
        channelPrintMap.put("UPS空派", x -> {
            try {
                Base64PrintUtil.base64Img(x,1000,1300,"png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        channelPrintMap.put("UPS一票多件", x -> {
            try {
                Base64PrintUtil.base64Img(x,1000,1300,"png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
