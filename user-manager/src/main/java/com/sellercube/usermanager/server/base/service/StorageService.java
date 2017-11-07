package com.sellercube.usermanager.server.base.service;


import com.github.pagehelper.PageInfo;
import com.sellercube.usermanager.common.BaseService;
import com.sellercube.usermanager.server.base.entity.Storage;
import com.sellercube.usermanager.server.base.entity.vo.StorageVO;


public interface StorageService extends BaseService<Storage>{

    PageInfo<StorageVO> list(Integer var1, Integer var2);

    PageInfo<StorageVO> search(String var1, Integer var2, Integer var3);
}