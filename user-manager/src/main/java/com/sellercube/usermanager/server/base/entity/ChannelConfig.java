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
public class ChannelConfig implements Serializable {
    private Integer id;

    private String name;

    private String clazz;

    private String method;

    private Date createTime;

    private String creator;

    private Date updateTime;

    private String updator;

    private Date delTime;

    private String deletor;

    private Boolean isDelete;
}