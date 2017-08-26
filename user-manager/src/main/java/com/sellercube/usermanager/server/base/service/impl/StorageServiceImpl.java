package com.sellercube.usermanager.server.base.service.impl;


import com.sellercube.usermanager.server.base.entity.Storage;
import com.sellercube.usermanager.server.base.mapper.StorageMapper;
import com.sellercube.usermanager.server.base.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService{

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public int deleteByPrimaryKey(Integer storageid) {
        return storageMapper.deleteByPrimaryKey(storageid);
    }

    @Override
    public int insert(Storage record) {
        return storageMapper.insert(record);
    }

    @Override
    public int insertSelective(Storage record) {
        return storageMapper.insertSelective(record);
    }

    @Override
    public Storage selectByPrimaryKey(Integer storageid) {
        return storageMapper.selectByPrimaryKey(storageid);
    }

    @Override
    public int updateByPrimaryKeySelective(Storage record) {
        return storageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Storage record) {
        return storageMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Storage> list() {
        return storageMapper.list();
    }
}