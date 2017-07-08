package com.sellercube.usermanager.server.base.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.sellercube.common.entity.View;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    @JsonView(View.BaseView.class)
    private Integer id;
    @JsonView(View.BaseView.class)
    private String name;
    @JsonView(View.BaseView.class)
    private String account;

    private String password;
    @JsonView(View.BaseView.class)
    private String email;
    @JsonView(View.BaseView.class)
    private Date createTime;
    @JsonView(View.BaseView.class)
    private String creator;
    @JsonView(View.BaseView.class)
    private Date updateTime;
    @JsonView(View.BaseView.class)
    private String updator;
    @JsonView(View.BaseView.class)
    private Date delTime;
    @JsonView(View.BaseView.class)
    private Boolean isDelete;
    @JsonView(View.BaseView.class)
    private String deltor;
    @JsonView(View.BaseView.class)
    private String role;
    @JsonView(View.BaseView.class)
    private String accessToken;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getDeltor() {
        return deltor;
    }

    public void setDeltor(String deltor) {
        this.deltor = deltor == null ? null : deltor.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", updateTime=" + updateTime +
                ", updator='" + updator + '\'' +
                ", delTime=" + delTime +
                ", isDelete=" + isDelete +
                ", deltor='" + deltor + '\'' +
                ", role='" + role + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}