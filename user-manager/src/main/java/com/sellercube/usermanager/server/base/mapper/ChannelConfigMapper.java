package com.sellercube.usermanager.server.base.mapper;

import com.sellercube.usermanager.common.BaseMapper;
import com.sellercube.usermanager.server.base.entity.ChannelConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ChannelConfigMapper extends BaseMapper<ChannelConfig> {

    /**
     * 根据渠道名称获取属性
     *
     * @param name 渠道名称
     */
    ChannelConfig selectByChannelName(String name);
}