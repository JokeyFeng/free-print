package com.sellercube.apigateway.server.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrintBindMapper {
    /**
     * 根据条件查询ip
     *
     * @param username  用户名
     * @param isEnable  是否启用
     * @param printType 打印类型
     * @return ip list
     */
    List<String> listByConditon(@Param("username") String username,
                                @Param("isEnable") Boolean isEnable,
                                @Param("printType") String printType);
}