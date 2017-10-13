package com.sellercube.usermanager.server.base.service.impl;

import com.sellercube.usermanager.server.base.entity.ChannelConfig;
import com.sellercube.usermanager.server.base.mapper.ChannelConfigMapper;
import com.sellercube.usermanager.server.base.service.ChannelConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chenjing on 2017/8/3.
 */
@Service
public class ChannelConfigServiceImpl implements ChannelConfigService {

    @Autowired
    private ChannelConfigMapper channelConfigMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return channelConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ChannelConfig record) {
        return channelConfigMapper.insert(record);
    }

    @Override
    public int insertSelective(ChannelConfig record) {
        return channelConfigMapper.insertSelective(record);
    }

    @Override
    public ChannelConfig selectByPrimaryKey(Integer id) {
        return channelConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ChannelConfig record) {
        return channelConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ChannelConfig record) {
        return channelConfigMapper.updateByPrimaryKey(record);
    }

    @Override
    public ChannelConfig selectByChannelName(String name) {
        return channelConfigMapper.selectByChannelName(name);
    }
}
