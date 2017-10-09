package com.sellercube.usermanager.server.base.entity;

import java.io.Serializable;

public class Storage implements Serializable {
    private Integer storageid;

    private Integer processcenterid;

    private String storagename;

    private Boolean isdefault;

    private Boolean checkstorageisgroup;

    private Boolean isinterchangecenter;

    private Integer companyid;

    private String enname;

    private Boolean ischina;

    private Boolean issamplestorage;

    private Boolean ispurchase;

    private Boolean isenable;

    private Integer sort;

    private String type;

    private Boolean isstockup;

    private Boolean isfba;

    private Boolean isseawaydelivery;

    private Long synckey;

    public Integer getStorageid() {
        return storageid;
    }

    public void setStorageid(Integer storageid) {
        this.storageid = storageid;
    }

    public Integer getProcesscenterid() {
        return processcenterid;
    }

    public void setProcesscenterid(Integer processcenterid) {
        this.processcenterid = processcenterid;
    }

    public String getStoragename() {
        return storagename;
    }

    public void setStoragename(String storagename) {
        this.storagename = storagename == null ? null : storagename.trim();
    }

    public Boolean getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
    }

    public Boolean getCheckstorageisgroup() {
        return checkstorageisgroup;
    }

    public void setCheckstorageisgroup(Boolean checkstorageisgroup) {
        this.checkstorageisgroup = checkstorageisgroup;
    }

    public Boolean getIsinterchangecenter() {
        return isinterchangecenter;
    }

    public void setIsinterchangecenter(Boolean isinterchangecenter) {
        this.isinterchangecenter = isinterchangecenter;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname == null ? null : enname.trim();
    }

    public Boolean getIschina() {
        return ischina;
    }

    public void setIschina(Boolean ischina) {
        this.ischina = ischina;
    }

    public Boolean getIssamplestorage() {
        return issamplestorage;
    }

    public void setIssamplestorage(Boolean issamplestorage) {
        this.issamplestorage = issamplestorage;
    }

    public Boolean getIspurchase() {
        return ispurchase;
    }

    public void setIspurchase(Boolean ispurchase) {
        this.ispurchase = ispurchase;
    }

    public Boolean getIsenable() {
        return isenable;
    }

    public void setIsenable(Boolean isenable) {
        this.isenable = isenable;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Boolean getIsstockup() {
        return isstockup;
    }

    public void setIsstockup(Boolean isstockup) {
        this.isstockup = isstockup;
    }

    public Boolean getIsfba() {
        return isfba;
    }

    public void setIsfba(Boolean isfba) {
        this.isfba = isfba;
    }

    public Boolean getIsseawaydelivery() {
        return isseawaydelivery;
    }

    public void setIsseawaydelivery(Boolean isseawaydelivery) {
        this.isseawaydelivery = isseawaydelivery;
    }

    public Long getSynckey() {
        return synckey;
    }

    public void setSynckey(Long synckey) {
        this.synckey = synckey;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "storageid=" + storageid +
                ", processcenterid=" + processcenterid +
                ", storagename='" + storagename + '\'' +
                ", isdefault=" + isdefault +
                ", checkstorageisgroup=" + checkstorageisgroup +
                ", isinterchangecenter=" + isinterchangecenter +
                ", companyid=" + companyid +
                ", enname='" + enname + '\'' +
                ", ischina=" + ischina +
                ", issamplestorage=" + issamplestorage +
                ", ispurchase=" + ispurchase +
                ", isenable=" + isenable +
                ", sort=" + sort +
                ", type='" + type + '\'' +
                ", isstockup=" + isstockup +
                ", isfba=" + isfba +
                ", isseawaydelivery=" + isseawaydelivery +
                ", synckey=" + synckey +
                '}';
    }
}