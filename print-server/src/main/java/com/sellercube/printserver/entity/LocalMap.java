package com.sellercube.printserver.entity;

import com.google.common.collect.Maps;
import com.sellercube.printserver.utils.Base64PrintUtil;

import java.util.Map;
import java.util.Set;
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
        channelPrintMap.put("FedEx", x -> {
                try {
                Base64PrintUtil.base64ImgCmd(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        channelPrintMap.put("FedEx空派", x -> {
            try {
                Base64PrintUtil.base64ImgCmd(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        channelPrintMap.put("FedEx一票多件", x -> {
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

   /* public static void main(String[] args) {
        String shipType="DPD邮政";

        Consumer<String> consumer = LocalMap.channelPrintMap.get(shipType);
        //临时添加渠道,
        if (consumer == null) {
            Set<String> keySet = LocalMap.channelPrintMap.keySet();
            for (String key : keySet) {
                if (key.contains(shipType.substring(0,3))){
                    LocalMap.channelPrintMap.put(shipType,LocalMap.channelPrintMap.get(key));
                    break;
                }
            }
            consumer = LocalMap.channelPrintMap.get(shipType);
            if (consumer==null) {
                System.out.println("不支持" + shipType + "渠道打印");
            }
        }
    }*/
}
