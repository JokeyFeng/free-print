package com.sellercube.usermanager.server.base.entity.vo;

import com.sellercube.usermanager.server.base.entity.PrintConfig;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
@Data
public class PrintConfigVO extends PrintConfig implements Serializable {

    private String storageName;

    private String operateUserName;

    private String createUserName;

    private String modifyUserName;

    private String deleteUserName;

    private String printTypeName;

}