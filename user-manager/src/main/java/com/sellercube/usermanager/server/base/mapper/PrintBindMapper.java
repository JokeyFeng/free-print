package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.server.base.entity.PrintBind;
import com.sellercube.usermanager.vo.JsonResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PrintBindMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrintBind record);

    int insertSelective(PrintBind record);

    PrintBind selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrintBind record);

    int updateByPrimaryKey(PrintBind record);

    List<JsonResult> searchByCondition(@Param("id") Integer id,
                                       @Param("config_id") Integer configId
            , @Param("type_id") Integer typeId
            , @Param("is_enable") Boolean isEnable
            , @Param("user_id") Integer userId);

    List<JsonResult> list();

    /**
     * 根据条件查询ip
     *
     * @param userId  用户id
     * @param isEnable  是否启用
     * @param printType 打印类型
     * @return ip list
     */
    List<String> listByCondition(@Param("userId") String userId,
                                 @Param("isEnable") Boolean isEnable,
                                 @Param("printType") String printType);
}