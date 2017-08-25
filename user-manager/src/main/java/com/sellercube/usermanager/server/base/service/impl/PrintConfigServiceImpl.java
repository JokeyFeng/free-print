package com.sellercube.usermanager.server.base.service.impl;

import com.sellercube.usermanager.server.base.entity.PrintConfig;
import com.sellercube.usermanager.server.base.mapper.PrintConfigMapper;
import com.sellercube.usermanager.server.base.service.PrintConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chenjing on 2017/8/24.
 */
@Service
public class PrintConfigServiceImpl implements PrintConfigService {

    @Autowired
    private PrintConfigMapper printConfigMapper;

    @Override
    public int deleteByPrimaryKey(Integer printConfigId) {
        return printConfigMapper.deleteByPrimaryKey(printConfigId);
    }

    @Override
    public int insert(PrintConfig record) {
        return printConfigMapper.insert(record);
    }

    @Override
    public int insertSelective(PrintConfig record) {
        return printConfigMapper.insertSelective(record);
    }

    @Override
    public PrintConfig selectByPrimaryKey(Integer printConfigId) {
        return printConfigMapper.selectByPrimaryKey(printConfigId);
    }

    @Override
    public int updateByPrimaryKeySelective(PrintConfig record) {
        return printConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PrintConfig record) {
        return printConfigMapper.updateByPrimaryKey(record);
    }
}
