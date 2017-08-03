package com.sellercube.printserver.server.service;

import com.sellercube.printserver.server.entity.ChannelConfig;


public interface ChannelConfigService {
    int deleteByPrimaryKey(Integer id);

    int insert(ChannelConfig record);

    int insertSelective(ChannelConfig record);

    ChannelConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChannelConfig record);

    int updateByPrimaryKey(ChannelConfig record);

    /**
     * 根据渠道名称获取属性
     *
     * @param name 渠道名称
     */
    ChannelConfig selectByChannelName(String name);
}