package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.server.base.entity.Opreator;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OpreatorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Opreator record);

    int insertSelective(Opreator record);

    Opreator selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Opreator record);

    int updateByPrimaryKey(Opreator record);

    List<Opreator> list();
}