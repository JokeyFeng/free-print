package com.sellercube.common.entity;

/**
 * Created by Chenjing on 2017/5/3.
 */
public enum HttpStatus {

    SUCCESS(200,"成功"),
    FAIL(400,"失败"),
    AUTH_FAIL(403, "抱歉，没有权限"),
    NOT_EXIST(404, "不存在");


    private int code;
    private String msg;

    HttpStatus(int code,String msg){
        this.setCode(code);
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
