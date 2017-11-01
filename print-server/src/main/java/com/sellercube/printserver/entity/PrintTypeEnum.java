package com.sellercube.printserver.entity;

/**
 * 打印类型枚举
 * Created by Chenjing on 2017/10/13.
 * @author Chenjing
 */
public enum PrintTypeEnum {
    //存取面单的中英文
    FACELIST("facelist", "面单"),
    //存取标签的中英文
    LABEL("label", "标签");

    private String englishName;
    private String chinesName;

    PrintTypeEnum(String englishName, String chinesName) {
        this.englishName = englishName;
        this.chinesName = chinesName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getChinesName() {
        return chinesName;
    }

    public void setChinesName(String chinesName) {
        this.chinesName = chinesName;
    }
}
