package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.server.base.entity.Ip;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IpMapper {
    int insert(Ip record);

    int insertSelective(Ip record);
}