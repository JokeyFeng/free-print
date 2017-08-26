package com.sellercube.usermanager.server.base.service;


import com.sellercube.usermanager.server.base.entity.Storage;

import java.util.List;


public interface StorageService {
    int deleteByPrimaryKey(Integer storageid);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Integer storageid);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

    List<Storage> list();
}