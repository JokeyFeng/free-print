package com.sellercube.common.entity;

/**
 * 打印参数
 * Created by Chenjing on 2017/10/13.
 */
public class PrintParam {
    private String userId;
    private String printType;
    private String from;
    private String shipType;
    private String content;
    private String format;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "PrintParam{" +
                "userId='" + userId + '\'' +
                ", printType='" + printType + '\'' +
                ", from='" + from + '\'' +
                ", shipType='" + shipType + '\'' +
                ", content='" + content + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
