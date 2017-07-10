package com.sellercube.usermanager.server.base.entity;

import java.io.Serializable;
import java.util.Date;

public class Config implements Serializable {
    private Integer id;

    private String ip;

    private String remark;

    private String mac;

    private String printName;

    private Date cretaeTime;

    private String creator;

    private Date updateTime;

    private String updator;

    private Date delTime;

    private String deletor;

    private Boolean isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getPrintName() {
        return printName;
    }

    public void setPrintName(String printName) {
        this.printName = printName == null ? null : printName.trim();
    }

    public Date getCretaeTime() {
        return cretaeTime;
    }

    public void setCretaeTime(Date cretaeTime) {
        this.cretaeTime = cretaeTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
    }

    public Date getDelTime() {
        return delTime;
    }

    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }

    public String getDeletor() {
        return deletor;
    }

    public void setDeletor(String deletor) {
        this.deletor = deletor == null ? null : deletor.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", ip=" + ip +
                ", remark='" + remark + '\'' +
                ", mac='" + mac + '\'' +
                ", printName='" + printName + '\'' +
                ", cretaeTime=" + cretaeTime +
                ", creator='" + creator + '\'' +
                ", updateTime=" + updateTime +
                ", updator='" + updator + '\'' +
                ", delTime=" + delTime +
                ", deletor='" + deletor + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}