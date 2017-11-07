package com.sellercube.usermanager.server.base.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
@Data
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

    private Boolean isEnable;

    private String printType;
}