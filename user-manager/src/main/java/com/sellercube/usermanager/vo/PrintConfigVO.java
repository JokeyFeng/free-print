package com.sellercube.usermanager.vo;

import java.io.Serializable;
import java.util.Date;

public class PrintConfigVO implements Serializable {
    private Integer printConfigId;

    private String machineIp;

    private String storageId;

    private Integer machinePort;

    private String operateUserName;

    private Date createDate;

    private String createUserName;

    private Date modifyDate;

    private String modifyUserName;

    private Date deleteDate;

    private String deleteUserName;

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
        this.machineIp = machineIp;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public Integer getMachinePort() {
        return machinePort;
    }

    public void setMachinePort(Integer machinePort) {
        this.machinePort = machinePort;
    }

    public String getOperateUserName() {
        return operateUserName;
    }

    public void setOperateUserName(String operateUserName) {
        this.operateUserName = operateUserName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getDeleteUserName() {
        return deleteUserName;
    }

    public void setDeleteUserName(String deleteUserName) {
        this.deleteUserName = deleteUserName;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "PrintConfigVO{" +
                "printConfigId=" + printConfigId +
                ", machineIp='" + machineIp + '\'' +
                ", storageId='" + storageId + '\'' +
                ", machinePort=" + machinePort +
                ", operateUserName='" + operateUserName + '\'' +
                ", createDate=" + createDate +
                ", createUserName='" + createUserName + '\'' +
                ", modifyDate=" + modifyDate +
                ", modifyUserName='" + modifyUserName + '\'' +
                ", deleteDate=" + deleteDate +
                ", deleteUserName='" + deleteUserName + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}