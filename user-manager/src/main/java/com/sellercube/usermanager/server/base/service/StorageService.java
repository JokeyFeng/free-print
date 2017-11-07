package com.sellercube.usermanager.server.base.service;


import com.github.pagehelper.PageInfo;
import com.sellercube.usermanager.common.BaseService;
import com.sellercube.usermanager.server.base.entity.Storage;
import com.sellercube.usermanager.server.base.entity.vo.StorageVO;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
public interface StorageService extends BaseService<Storage> {
    /**
     * 分页获取仓库
     *
     * @param var1 page number
     * @param var2 limit size
     * @return {@link PageInfo<StorageVO>}
     */
    PageInfo<StorageVO> list(Integer var1, Integer var2);

    /**
     * 分页搜索仓库
     *
     * @param var1 storage name
     * @param var2 page number
     * @param var3 limit size
     * @return {@link PageInfo<StorageVO>}
     */
    PageInfo<StorageVO> search(String var1, Integer var2, Integer var3);
}