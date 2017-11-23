package com.sellercube.printserver.entity;

/**
 * 打印类型枚举
 * Created by Chenjing on 2017/10/13.
 *
 * @author Chenjing
 */
public enum PrintMethodEnum {
    BASE64_PDF("com.sellercube.printserver.utils.ChannelUtil", "base64Pdf"),
    BASE64_IMG("com.sellercube.printserver.utils.ChannelUtil", "base64Img"),
    BASE64_CMD("com.sellercube.printserver.utils.ChannelUtil", "base64PrintCmd");

    private String name;
    private String clazz;
    private String method;

    PrintMethodEnum(String clazz, String method) {
        this.clazz = clazz;
        this.method = method;
    }

    public String getClazz() {
        return clazz;
    }

    public String getMethod() {
        return method;
    }
}
