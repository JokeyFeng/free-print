package com.sellercube.common.utils;

import com.sellercube.common.entity.HttpStatus;
import com.sellercube.common.entity.Result;


/**
 * Created by chenjing on 2017/5/3.
 */
public class ResultUtil {
    public static Result error(Object object){
        Result<Object> result=new Result<>();
        result.setCode(HttpStatus.FAIL.getCode());
        result.setMsg(HttpStatus.FAIL.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success(Object object){
        Result<Object> result=new Result<>();
        result.setCode(HttpStatus.SUCCESS.getCode());
        result.setMsg(HttpStatus.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result authFail(Object object){
        Result<Object> result=new Result<>();
        result.setCode(HttpStatus.AUTH_FAIL.getCode());
        result.setMsg(HttpStatus.AUTH_FAIL.getMsg());
        result.setData(object);
        return result;
    }
}
