package com.sellercube.usermanager.server.base.entity;

import java.io.Serializable;
import java.util.Date;

public class PrintConfig implements Serializable {
    private Integer printConfigId;

    private String machineIp;

    private Integer storageId;

    private Integer machinePort;

    private Integer operateUserId;

    private Date createDate;

    private Integer createUserId;

    private Date modifyDate;

    private Integer modifyUserId;

    private Date deleteDate;

    private Integer deleteUserid;

    private Boolean isDeleted;

    public Integer getPrintConfigId() {
        return printConfigId;
    }

    public void setPrintConfigId(Integer printConfigId) {
        this.printConfigId = printConfigId;
    }

    public String getMachineIp() {
        return machineIp;
    }

    public void setMachineIp(String machineIp) {
        this.machineIp = machineIp == null ? null : machineIp.trim();
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public Integer getMachinePort() {
        return machinePort;
    }

    public void setMachinePort(Integer machinePort) {
        this.machinePort = machinePort;
    }

    public Integer getOperateUserId() {
        return operateUserId;
    }

    public void setOperateUserId(Integer operateUserId) {
        this.operateUserId = operateUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public Integer getDeleteUserid() {
        return deleteUserid;
    }

    public void setDeleteUserid(Integer deleteUserid) {
        this.deleteUserid = deleteUserid;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "PrintConfig{" +
                "printConfigId=" + printConfigId +
                ", machineIp='" + machineIp + '\'' +
                ", storageId=" + storageId +
                ", machinePort=" + machinePort +
                ", operateUserId=" + operateUserId +
                ", createDate=" + createDate +
                ", createUserId=" + createUserId +
                ", modifyDate=" + modifyDate +
                ", modifyUserId=" + modifyUserId +
                ", deleteDate=" + deleteDate +
                ", deleteUserid=" + deleteUserid +
                ", isDeleted=" + isDeleted +
                '}';
    }
}