package com.sellercube.printserver.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer userid;

    private Integer processcenterid;

    private Integer defaultstorageid;

    private Integer departmentid;

    private String username;

    private String password;

    private String email;

    private Boolean islocked;

    private Date lastlogintime;

    private Integer deliveraddress;

    private Integer defaultlanguageid;

    private String newpassword;

    private Long synckey;

    private Short testusertype;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProcesscenterid() {
        return processcenterid;
    }

    public void setProcesscenterid(Integer processcenterid) {
        this.processcenterid = processcenterid;
    }

    public Integer getDefaultstorageid() {
        return defaultstorageid;
    }

    public void setDefaultstorageid(Integer defaultstorageid) {
        this.defaultstorageid = defaultstorageid;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public Boolean getIslocked() {
        return islocked;
    }

    public void setIslocked(Boolean islocked) {
        this.islocked = islocked;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Integer getDeliveraddress() {
        return deliveraddress;
    }

    public void setDeliveraddress(Integer deliveraddress) {
        this.deliveraddress = deliveraddress;
    }

    public Integer getDefaultlanguageid() {
        return defaultlanguageid;
    }

    public void setDefaultlanguageid(Integer defaultlanguageid) {
        this.defaultlanguageid = defaultlanguageid;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword == null ? null : newpassword.trim();
    }

    public Long getSynckey() {
        return synckey;
    }

    public void setSynckey(Long synckey) {
        this.synckey = synckey;
    }

    public Short getTestusertype() {
        return testusertype;
    }

    public void setTestusertype(Short testusertype) {
        this.testusertype = testusertype;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", processcenterid=" + processcenterid +
                ", defaultstorageid=" + defaultstorageid +
                ", departmentid=" + departmentid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", islocked=" + islocked +
                ", lastlogintime=" + lastlogintime +
                ", deliveraddress=" + deliveraddress +
                ", defaultlanguageid=" + defaultlanguageid +
                ", newpassword='" + newpassword + '\'' +
                ", synckey=" + synckey +
                ", testusertype=" + testusertype +
                '}';
    }
}