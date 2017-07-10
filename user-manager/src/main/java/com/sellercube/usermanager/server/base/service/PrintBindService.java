package com.sellercube.usermanager.server.base.service;

import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.PrintBind;
import com.sellercube.usermanager.vo.JsonResult;

/**
 * Author:Administrator
 * Date: 2017/7/10
 * Email:JokeyFeng@foxmail.com
 * Version:1.0.0
 */
public interface PrintBindService {

    /**新增打印绑定**/
    int insert(PrintBind record);
    int insertSelective(PrintBind record);

    /**根据主键删除打印绑定**/
    int deleteByPrimaryKey(Integer id);

    /**根据主键查询**/
    PrintBind selectByPrimaryKey(Integer id);

    /**根据主键修改**/
    int updateByPrimaryKey(PrintBind record);
    int updateByPrimaryKeySelective(PrintBind record);

    /**根据多重条件进行查询**/
    PageInfo<JsonResult> searchByCondition(Integer configId
                                        , Integer typeId
                                        , boolean isEnable
                                        , Integer userId
                                        , Integer pageNum, Integer PageSize);

    /**分页查询**/
    PageInfo<JsonResult> getByPage(Integer pageNum, Integer pageSize);
}
