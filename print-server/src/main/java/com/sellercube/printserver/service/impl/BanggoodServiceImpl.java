package com.sellercube.printserver.service.impl;

import com.google.common.collect.Maps;
import com.sellercube.printserver.entity.DotNetFba;
import com.sellercube.printserver.entity.PrintParam;
import com.sellercube.printserver.executors.BackToEds;
import com.sellercube.printserver.service.BanggoodService;
import com.sellercube.printserver.utils.Base64PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * 棒谷接口
 * Created by Chenjing on 2017/7/15.
 *
 * @author Chenjing
 */
@Service
@Slf4j
public class BanggoodServiceImpl implements BanggoodService {

    public BanggoodServiceImpl() {
    }

    @Autowired
    public BanggoodServiceImpl(BackToEds backToEds) {
        this.backToEds = backToEds;
    }

    private static Map<String, Consumer<String>> map = Maps.newHashMap();

    static {
        map.put("Fedex", x -> {
            try {
                Base64PrintUtil.base64ImgCmd(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        map.put("DHL", x -> {
            try {
                Base64PrintUtil.base64Pdf(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        map.put("DPD", x -> {
            try {
                Base64PrintUtil.base64PrintCmd(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private BackToEds backToEds;

    @Override
    public String process(PrintParam printParam) throws Exception {
        DotNetFba dotnetFba = printParam.getData();
        String pdfUrl = dotnetFba.getPdfUrl();
        String shipType = dotnetFba.getShipType();
        Objects.requireNonNull(shipType, "棒谷渠道shipType为null");
        if (Objects.equals(null, pdfUrl) || Objects.equals("", pdfUrl)) {
            throw new Exception("打印失败，PDFUrl内容为空");
        }

        //还原特殊字符串
        pdfUrl = this.convertStr(pdfUrl);

        Consumer<String> consumer = map.get(shipType);
        if (consumer == null) {
            throw new Exception("不支持" + shipType + "渠道打印");
        }
        consumer.accept(pdfUrl);
        backToEds.backFbaCode(dotnetFba.getFbaCode(), printParam.getUserId());
        return "打印成功";
    }

    /**
     * .net那边对特殊字符进行了转换，现在转换过来
     *
     * @param str 字符串
     * @return 原生的数据
     */
    private String convertStr(String str) {
        return StringUtils.replace(str, "--jiahao--", "+")
                .replace("--wenhao--", "?")
                .replace("--baifeng--", "%")
                .replace("--jin--", "#")
                .replace("--su--", "/");
    }
}