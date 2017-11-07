package com.sellercube.usermanager.server.base.service;


import com.sellercube.usermanager.common.BaseService;
import com.sellercube.usermanager.server.base.entity.ChannelConfig;

public interface ChannelConfigService extends BaseService<ChannelConfig> {

    /**
     * 根据渠道名称获取属性
     *
     * @param name 渠道名称
     */
    ChannelConfig selectByChannelName(String name);
}