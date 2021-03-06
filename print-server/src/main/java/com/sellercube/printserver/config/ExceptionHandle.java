package com.sellercube.printserver.config;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenjing on 2017/4/11.
 * @author Chenjing
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        log.error("【系统异常】=>{}",e);
        return ResultUtil.error(e.getMessage());
    }
}
