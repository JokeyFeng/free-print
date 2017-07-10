package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.server.base.entity.Config;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Config record);

    int insertSelective(Config record);

    Config selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);

    List<Config> list();

    List<Config> searchByCondition(@Param("printName") String printName, @Param("ip") String ip, @Param("mac") String mac);

    int countByPrintNameRepeat(String printName);
}