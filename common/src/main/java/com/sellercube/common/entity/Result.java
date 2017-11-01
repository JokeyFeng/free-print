package com.sellercube.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 统一返回结果
 * Created by chenjing on 2017/5/3.
 * @author Chenjing
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;
}
