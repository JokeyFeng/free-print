package com.sellercube.usermanager.server.base.entity;

import java.util.Date;

public class PrintBind {
    private Integer id;

    private Integer configId;

    private Integer printTypeId;

    private Boolean isEnable;

    private Integer userId;

    private String file;

    private Date createTime;

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

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public Integer getPrintTypeId() {
        return printTypeId;
    }

    public void setPrintTypeId(Integer printTypeId) {
        this.printTypeId = printTypeId;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public PrintBind(Integer configId, Integer printTypeId, Boolean isEnable, Integer userId, String file, Date createTime, String creator, Date updateTime, String updator) {
        this.configId = configId;
        this.printTypeId = printTypeId;
        this.isEnable = isEnable;
        this.userId = userId;
        this.file = file;
        this.createTime = createTime;
        this.creator = creator;
        this.updateTime = updateTime;
        this.updator = updator;
    }

    public PrintBind(){}
}