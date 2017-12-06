package com.sellercube.printserver.entity;

import lombok.Data;

/**
 * Created by Chenjing on 2017/11/17.
 *
 * @author Chenjing
 */
@Data
public class Printer {

    /**
     * 用户id
     */
    private String userId;
    /**
     * 文件后缀名
     */
    private String suffix;
    /**
     * 打印类型
     */
    private String printType;
    /**
     * 打印方法枚举
     * {@link PrintMethodConstant}
     */
    private String printMethod;
    /**
     * 需要打印的base64加密的数据
     */
    private String base64Str;
    /**
     * 长度 单位mm
     */
    private int length;
    /**
     * 宽度 单位mm
     */
    private int width;
}
