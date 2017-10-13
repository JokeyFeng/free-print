package com.sellercube.usermanager.server.base.mapper;

import com.sellercube.usermanager.server.base.entity.ChannelConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ChannelConfigMapper {
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