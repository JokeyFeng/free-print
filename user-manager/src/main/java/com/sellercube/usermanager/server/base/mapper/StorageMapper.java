package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.server.base.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StorageMapper {
    int deleteByPrimaryKey(Integer storageid);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Integer storageid);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

    List<Storage> list();
}