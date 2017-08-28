package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.server.base.entity.PrintConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PrintConfigMapper {
    int deleteByPrimaryKey(Integer printConfigId);

    int insert(PrintConfig record);

    int insertSelective(PrintConfig record);

    PrintConfig selectByPrimaryKey(Integer printConfigId);

    int updateByPrimaryKeySelective(PrintConfig record);

    int updateByPrimaryKey(PrintConfig record);

    List<PrintConfig> list();

    List<PrintConfig> searchByCondition(@Param("username") String operateName, @Param("ip") String ip,@Param("warehouseId") Integer warehouseId);

    List<String> distinctByIP();
}