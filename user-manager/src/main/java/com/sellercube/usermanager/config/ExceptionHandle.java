package com.sellercube.usermanager.config;

import com.sellercube.common.entity.Result;
import com.sellercube.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Chenjing on 2017/6/20.
 *
 * @author Chenjing
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        log.error("【系统异常】：{}", e);
        return ResultUtil.error(e.getMessage());
    }
}
