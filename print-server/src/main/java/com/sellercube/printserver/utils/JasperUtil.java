package com.sellercube.printserver.utils;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.core.io.ClassPathResource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chenjing on 2017/12/28.
 *
 * @author Chenjing
 */
public class JasperUtil {

    public static void main(String[] args) throws Exception {
        Map<String, Object> rptParameters = new HashMap<>();
        rptParameters.put("poaOrSku", "POA10000");
        rptParameters.put("size", "Black XL（黑色XL）");
        rptParameters.put("boxNo", "A-A-01-01");
        ClassPathResource resource = new ClassPathResource("template/poa.jasper");

        //传入报表源文件绝对路径，外部参数对象，DB连接，得到JasperPring对象
        JasperPrint jasperPrint = JasperFillManager.fillReport(resource.getInputStream(),
                rptParameters, new JREmptyDataSource());
        //导出PDF文件
        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "C:/Users/Administrator/Desktop/test.pdf");
        //执行结束
        System.out.println("Export success!!");
    }
}
