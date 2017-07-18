package com.sellercube.usermanager.server.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.Monitor;
import com.sellercube.usermanager.server.base.mapper.MonitorMapper;
import com.sellercube.usermanager.server.base.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chenjing on 2017/7/18.
 */
@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorMapper monitorMapper;

    @Override
    public PageInfo<Monitor> list(String pageNum, String limit) {
        PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(limit));
        return new PageInfo<>(monitorMapper.list());
    }
}
