package com.sellercube.apigateway.server.entity;

import java.io.Serializable;
import java.util.Date;

public class Monitor implements Serializable {
    private Integer id;

    private String docName;

    private String status;

    private int pageSize;

    private Double size;

    private Date commitTime;

    private String port;

    private String belongUser;

    private Date createTime;

    private String creator;

    private Date updateTime;

    private String updator;

    private Date delTime;

    private String deletor;

    private String isDeletor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getBelongUser() {
        return belongUser;
    }

    public void setBelongUser(String belongUser) {
        this.belongUser = belongUser == null ? null : belongUser.trim();
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

    public String getIsDeletor() {
        return isDeletor;
    }

    public void setIsDeletor(String isDeletor) {
        this.isDeletor = isDeletor == null ? null : isDeletor.trim();
    }
}