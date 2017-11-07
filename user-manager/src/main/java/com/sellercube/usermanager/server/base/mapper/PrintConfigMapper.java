package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.common.BaseMapper;
import com.sellercube.usermanager.server.base.entity.PrintConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PrintConfigMapper extends BaseMapper<PrintConfig> {

    List<PrintConfig> list();

    List<PrintConfig> searchByCondition(@Param("operateUserId") String operateUserId, @Param("ip") String ip,
                                        @Param("warehouseId") Integer warehouseId);
}