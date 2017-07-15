package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.server.base.entity.PrintBind;
import com.sellercube.usermanager.vo.JsonResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrintBindMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrintBind record);

    int insertSelective(PrintBind record);

    PrintBind selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrintBind record);

    int updateByPrimaryKey(PrintBind record);

    List<JsonResult> searchByCondition(@Param("config_id") Integer configId
                                    , @Param("type_id")Integer typeId
                                    , @Param("is_enable")Boolean isEnable
                                    , @Param("user_id")Integer userId);

    List<JsonResult> list();
}