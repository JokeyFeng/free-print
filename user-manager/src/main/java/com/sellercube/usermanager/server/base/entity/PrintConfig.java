package com.sellercube.usermanager.server.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
@Data
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

    private Integer printTypeId;

    private Boolean isEnable;

}