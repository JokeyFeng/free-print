package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.server.base.entity.PrintBind;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrintBindMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrintBind record);

    int insertSelective(PrintBind record);

    PrintBind selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrintBind record);

    int updateByPrimaryKey(PrintBind record);
}