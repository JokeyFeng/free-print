package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.server.base.entity.printType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface printTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(printType record);

    int insertSelective(printType record);

    printType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(printType record);

    int updateByPrimaryKey(printType record);
}