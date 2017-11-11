package com.sellercube.usermanager.server.base.mapper;

import com.sellercube.usermanager.common.BaseMapper;
import com.sellercube.usermanager.server.base.entity.ChannelConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
@Mapper
@Component
public interface ChannelConfigMapper extends BaseMapper<ChannelConfig> {

    /**
     * 根据渠道名称查询
     *
     * @param name 渠道名称
     * @return {@link ChannelConfig}
     */
    ChannelConfig selectByChannelName(String name);
}