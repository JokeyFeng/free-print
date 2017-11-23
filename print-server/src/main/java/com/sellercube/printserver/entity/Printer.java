package com.sellercube.printserver.entity;

import lombok.Data;

/**
 * Created by Chenjing on 2017/11/17.
 *
 * @author Chenjing
 */
@Data
public class Printer {

    private String userId;

    private String suffix;

    private String printType;

    private String printMethod;

    private String base64Str;

    private int length;

    private int width;
}
