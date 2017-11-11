package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.common.BaseMapper;
import com.sellercube.usermanager.server.base.entity.Storage;
import com.sellercube.usermanager.server.base.entity.vo.StorageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
@Mapper
@Component
public interface StorageMapper extends BaseMapper<Storage> {

    /**
     * 分页获取仓库
     *
     * @return {@link List<StorageVO>}
     */
    List<StorageVO> list();

    /**
     * 根据仓库名分页搜索
     *
     * @param storageName 仓库名称
     * @return {@link List<StorageVO>}
     */
    List<StorageVO> search(String storageName);
}