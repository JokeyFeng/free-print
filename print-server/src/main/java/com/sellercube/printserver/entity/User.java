package com.sellercube.printserver.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Chenjing on 2017/11/11
 *
 * @author Chenjing
 */
@Data
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
}