package com.sellercube.common.entity;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * Created by chenjing on 2017/5/3.
 * 统一返回结果
 */
public class Result<T> implements Serializable {
    @JsonView(ResultJsonView.BaseView.class)
    private Integer code;

    @JsonView(ResultJsonView.BaseView.class)
    private String msg;

    @JsonView(ResultJsonView.BaseView.class)
    private T data;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
