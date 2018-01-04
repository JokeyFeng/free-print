package com.sellercube.printserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sellercube.printserver.entity.OpenBox;
import com.sellercube.printserver.entity.Printer;
import com.sellercube.printserver.service.PrintService;
import com.sellercube.printserver.utils.FileUtil;
import com.sellercube.printserver.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

import static com.sellercube.printserver.entity.PrintMethodConstant.*;
import static com.sellercube.printserver.utils.Base64PrintUtil.*;

/**
 * Created by Chenjing on 2017/11/10.
 *
 * @author Chenjing
 */
@Service
@Slf4j
public class PrintServiceImpl implements PrintService {

    @Override
    public String print(Printer param) throws Exception {
        switch (param.getPrintMethod()) {
            case BASE64_PDF:
                base64Pdf(param.getBase64Str());
                break;
            case BASE64_IMG:
                if (param.getLength() != 0 && param.getLength() != 0) {
                    base64Img(param.getBase64Str(), param.getWidth(), param.getLength(), param.getPrintType());
                } else {
                    base64Img(param.getBase64Str());
                }
                break;
            case BASE64_CMD:
                base64PrintCmd(param.getBase64Str());
                break;
            default:
                throw new Exception("不支持" + param.getPrintMethod() + "打印方法");
        }
        return "打印成功";
    }

    /**
     * 对手持的开箱入库进行模板打印
     *
     * @param openBox 实体
     * @return 打印成功
     * @throws Exception 异常
     */
    @SuppressWarnings("unchecked")
    @Override
    public String printModel(OpenBox openBox) throws Exception {
        Objects.requireNonNull(openBox, "实体为空");
        Map<String, Object> paramNumber = JSONObject.parseObject(JSON.toJSONString(openBox.getProductNumber()), Map.class);
        Map<String, Object> paramDetail = JSONObject.parseObject(JSON.toJSONString(openBox.getProductDetail()), Map.class);
        //生成第一个pdf
        String numberPath = FileUtil.jasperToPdf(paramNumber, "template/sftmodel.jasper");
        PrintUtil.printPDF(numberPath);
        //生成第二个pdf
        String detailPath = FileUtil.jasperToPdf(paramDetail, "template/poa.jasper");
        PrintUtil.printPDF(detailPath);
        return "打印成功";
    }
}
