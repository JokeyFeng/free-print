package com.sellercube.usermanager.server.base.service;


import com.sellercube.usermanager.server.base.entity.PrintConfig;

public interface PrintConfigService {
    int deleteByPrimaryKey(Integer printConfigId);

    int insert(PrintConfig record);

    int insertSelective(PrintConfig record);

    PrintConfig selectByPrimaryKey(Integer printConfigId);

    int updateByPrimaryKeySelective(PrintConfig record);

    int updateByPrimaryKey(PrintConfig record);
}