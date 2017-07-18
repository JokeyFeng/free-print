package com.sellercube.usermanager.server.base.service;

import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.Monitor;

/**
 * Created by Chenjing on 2017/7/18.
 */
public interface MonitorService {
    PageInfo<Monitor> list(String pageNum, String limit);
}
