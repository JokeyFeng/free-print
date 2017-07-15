package com.sellercube.apigateway.server.mapper;


import com.sellercube.apigateway.server.entity.Monitor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MonitorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Monitor record);

    int insertSelective(Monitor record);

    Monitor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Monitor record);

    int updateByPrimaryKey(Monitor record);
}