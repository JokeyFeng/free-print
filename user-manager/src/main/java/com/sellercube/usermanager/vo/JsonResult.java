package com.sellercube.usermanager.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Author:Administrator
 * Date: 2017/7/10
 * Email:JokeyFeng@foxmail.com
 * Version:1.0.0
 */
public class JsonResult implements Serializable {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**打印机名称**/
    private String printName;
    /**打印类型**/
    private String typeName;
    /**是否可用**/
    private boolean isEnable;
    /**操作人**/
    private String operator;
    /**创建人**/
    private String creator;
    /**创建时间**/
    private Date createTime;
    /**最后修改人**/
    private String editor;
    /**最后修改时间**/
    private Date updateTime;

    public String getPrintName() {
        return printName;
    }

    public void setPrintName(String printName) {
        this.printName = printName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "printName='" + printName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", isEnable=" + isEnable +
                ", operator='" + operator + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", editor='" + editor + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
