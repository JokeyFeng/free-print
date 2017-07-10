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

    /**
     * 新增打印绑定信息
     * @param record
     * @return
     * @throws Exception
     */
    int insert(PrintBind record) throws Exception;
    int insertSelective(PrintBind record) throws Exception;

    /**
     * 根据主键删除打印绑定信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteByKeys(String ids);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    PrintBind selectByPrimaryKey(Integer id);

    /**
     * 根据主键修改
     * @param record
     * @return
     * @throws Exception
     */
    int updateByPrimaryKey(PrintBind record) throws Exception;
    int updateByPrimaryKeySelective(PrintBind record) throws Exception;

    /**
     * 根据多重条件进行查询
     * @param configId
     * @param typeId
     * @param isEnable
     * @param userId
     * @param pageNum
     * @param PageSize
     * @return
     */
    PageInfo<JsonResult> searchByCondition(Integer configId
                                        , Integer typeId
                                        , boolean isEnable
                                        , Integer userId
                                        , Integer pageNum, Integer PageSize);

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<JsonResult> getByPage(Integer pageNum, Integer pageSize);
}
