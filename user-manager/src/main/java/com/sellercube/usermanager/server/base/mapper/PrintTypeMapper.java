package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.server.base.entity.PrintType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrintTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrintType record);

    int insertSelective(PrintType record);

    PrintType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrintType record);

    int updateByPrimaryKey(PrintType record);

    List<PrintType> searchByName(String name);

    List<PrintType> list();
}