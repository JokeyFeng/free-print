package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.server.base.entity.PrintConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PrintConfigMapper {
    int deleteByPrimaryKey(Integer printConfigId);

    int insert(PrintConfig record);

    int insertSelective(PrintConfig record);

    PrintConfig selectByPrimaryKey(Integer printConfigId);

    int updateByPrimaryKeySelective(PrintConfig record);

    int updateByPrimaryKey(PrintConfig record);
}