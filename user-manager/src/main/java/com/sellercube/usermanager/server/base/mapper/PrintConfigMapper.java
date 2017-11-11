package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.common.BaseMapper;
import com.sellercube.usermanager.server.base.entity.PrintConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
@Mapper
@Component
public interface PrintConfigMapper extends BaseMapper<PrintConfig> {
    /**
     * 分页获取手持IP配置列表
     *
     * @return {@link List<PrintConfig>}
     */
    List<PrintConfig> list();

    /**
     * 根据条件查询
     *
     * @param operateUserId 操作员id
     * @param warehouseId   仓库id
     * @return {@link List<PrintConfig>}
     */
    List<PrintConfig> searchByCondition(@Param("operateUserId") String operateUserId, @Param("warehouseId") Integer warehouseId);

    /**
     * 根据用户名和打印类型进行查询
     *
     * @param userId      操作员id
     * @param printTypeId 打印类型 id
     * @return ip
     */
    List<String> findIpByCondition(@Param("userId") String userId, @Param("printTypeId") String printTypeId);
}