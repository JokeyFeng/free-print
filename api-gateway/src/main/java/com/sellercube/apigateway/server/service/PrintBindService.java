package com.sellercube.apigateway.server.service;

import java.util.List;

/**
 * Create by Chenjing on 2017/7/15.
 */
public interface PrintBindService {

    List<String> listByConditon(String userId, String printType, Boolean isEnable);
}
