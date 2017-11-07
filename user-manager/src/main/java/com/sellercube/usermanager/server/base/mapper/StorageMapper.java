package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.common.BaseMapper;
import com.sellercube.usermanager.server.base.entity.Storage;
import com.sellercube.usermanager.server.base.entity.vo.StorageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StorageMapper extends BaseMapper<Storage> {

    List<StorageVO> list();

    List<StorageVO> search(String storageName);
}