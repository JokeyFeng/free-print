package com.sellercube.apigateway.server.service.impl;


import com.sellercube.apigateway.server.mapper.PrintBindMapper;
import com.sellercube.apigateway.server.service.PrintBindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Chenjing on 2017/7/15.
 */
@Service
public class PrintBindServiceImpl implements PrintBindService {

    @Autowired
    private PrintBindMapper printBindMapper;

    @Override
    public List<String> listByConditon(String username, String printType, Boolean isEnable) {
        return printBindMapper.listByConditon(username, isEnable, printType);
    }
}
