package com.sellercube.usermanager.server.base.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
@Data
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
}