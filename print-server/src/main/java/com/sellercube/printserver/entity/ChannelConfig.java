package com.sellercube.printserver.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Chenjing
 */
@Data
@Accessors(chain = true)
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