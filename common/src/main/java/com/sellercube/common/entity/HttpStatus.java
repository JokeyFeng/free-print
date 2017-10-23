package com.sellercube.common.entity;

/**
 * Created by Chenjing on 2017/5/3.
 */
public enum HttpStatus {

    //项目返回成功
    SUCCESS(200, "成功"),
    //项目返回失败
    FAIL(400, "失败"),
    //项目返回没有权限
    AUTH_FAIL(403, "抱歉，没有权限"),
    //项目返回404 不存在
    NOT_EXIST(404, "不存在");


    private int code;
    private String msg;

    HttpStatus(int code, String msg) {
        this.setCode(code);
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
