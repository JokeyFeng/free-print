package com.sellercube.usermanager.server.base.entity;

import java.io.Serializable;
import java.util.Date;

public class Config implements Serializable {
    private Integer id;

    private Integer opreatorId;

    private Integer ipId;

    private Integer printTypeId;

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

    public Integer getOpreatorId() {
        return opreatorId;
    }

    public void setOpreatorId(Integer opreatorId) {
        this.opreatorId = opreatorId;
    }

    public Integer getIpId() {
        return ipId;
    }

    public void setIpId(Integer ipId) {
        this.ipId = ipId;
    }

    public Integer getPrintTypeId() {
        return printTypeId;
    }

    public void setPrintTypeId(Integer printTypeId) {
        this.printTypeId = printTypeId;
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

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", opreatorId=" + opreatorId +
                ", ipId=" + ipId +
                ", printTypeId=" + printTypeId +
                ", cretaeTime=" + cretaeTime +
                ", creator='" + creator + '\'' +
                ", updateTime=" + updateTime +
                ", updator='" + updator + '\'' +
                ", delTime=" + delTime +
                ", deletor='" + deletor + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}