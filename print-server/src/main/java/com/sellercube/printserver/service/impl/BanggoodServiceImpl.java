package com.sellercube.printserver.service.impl;

import com.sellercube.printserver.entity.DotNetFba;
import com.sellercube.printserver.entity.LocalMap;
import com.sellercube.printserver.entity.PrintParam;
import com.sellercube.printserver.executors.BackToEds;
import com.sellercube.printserver.service.BanggoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Set;
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
        //首次匹配邮寄方式
        Consumer<String> consumer = LocalMap.channelPrintMap.get(shipType);
        if (consumer == null) {
            //临时添加渠道的邮寄方式,取邮寄方式的首3个字符进行匹配
            Set<String> keySet = LocalMap.channelPrintMap.keySet();
            for (String key : keySet) {
                if (key.contains(shipType.substring(0,3))){
                    LocalMap.channelPrintMap.put(shipType,LocalMap.channelPrintMap.get(key));
                    break;
                }
            }
            //再次去获取
            consumer = LocalMap.channelPrintMap.get(shipType);
            Assert.notNull(consumer,"不支持" + shipType + "渠道打印");
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