package com.sellercube.usermanager.server.base.service.impl;

import com.sellercube.usermanager.common.BaseServiceImpl;
import com.sellercube.usermanager.server.base.entity.ChannelConfig;
import com.sellercube.usermanager.server.base.mapper.ChannelConfigMapper;
import com.sellercube.usermanager.server.base.service.ChannelConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chenjing on 2017/8/3.
 * @author Chenjing
 */
@Service
public class ChannelConfigServiceImpl extends BaseServiceImpl<ChannelConfig> implements ChannelConfigService {

    private ChannelConfigMapper channelConfigMapper;

    public ChannelConfigServiceImpl() {
    }

    @Autowired
    public ChannelConfigServiceImpl(ChannelConfigMapper var1) {
        this.channelConfigMapper = var1;
        super.baseMapper = var1;
    }

    @Override
    public ChannelConfig selectByChannelName(String name) {
        return channelConfigMapper.selectByChannelName(name);
    }
}
