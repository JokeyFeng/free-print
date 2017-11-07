package com.sellercube.usermanager.server.base.service;


import com.sellercube.usermanager.common.BaseService;
import com.sellercube.usermanager.server.base.entity.ChannelConfig;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
public interface ChannelConfigService extends BaseService<ChannelConfig> {

    /**
     * 根据渠道名称获取属性
     *
     * @param name 渠道名称
     * @return {@link ChannelConfig}
     */
    ChannelConfig selectByChannelName(String name);
}