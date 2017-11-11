package com.sellercube.usermanager.server.base.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sellercube.usermanager.common.BaseServiceImpl;
import com.sellercube.usermanager.server.base.entity.Storage;
import com.sellercube.usermanager.server.base.entity.vo.StorageVO;
import com.sellercube.usermanager.server.base.mapper.StorageMapper;
import com.sellercube.usermanager.server.base.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
@Service
public class StorageServiceImpl extends BaseServiceImpl<Storage> implements StorageService {

    public StorageServiceImpl() {
    }

    private StorageMapper storageMapper;

    @Autowired
    public StorageServiceImpl(StorageMapper var1) {
        super.baseMapper = var1;
        this.storageMapper = var1;
    }

    @Override
    public PageInfo<StorageVO> list(Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        return new PageInfo<>(storageMapper.list());
    }

    @Override
    public PageInfo<StorageVO> search(String storageName, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        return new PageInfo<>(storageMapper.search(storageName));
    }
}