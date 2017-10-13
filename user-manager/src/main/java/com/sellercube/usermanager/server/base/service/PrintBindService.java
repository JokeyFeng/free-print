package com.sellercube.usermanager.server.base.service;

import com.alibaba.fastjson.JSONArray;
import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.PrintBind;
import com.sellercube.usermanager.vo.JsonResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Author:Administrator
 * Date: 2017/7/10
 * Email:JokeyFeng@foxmail.com
 * Version:1.0.0
 */
public interface PrintBindService {

    /**
     * 新增打印绑定信息
     *
     * @param
     * @return
     * @throws Exception
     */
    int insert(Integer printNameId, Integer printTypeId, boolean isEnable, Integer userId, MultipartFile file, String creator) throws Exception;

    int insertSelective(Integer printNameId, Integer printTypeId, boolean isEnable, Integer userId, MultipartFile file, String creator) throws Exception;

    /**
     * 根据主键删除打印绑定信息
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteByKeys(String ids);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    PrintBind selectByPrimaryKey(Integer id);

    /**
     * 根据主键修改
     *
     * @param
     * @return
     * @throws Exception
     */
    int updateByPrimaryKey(Integer id, Integer printNameId, Integer printTypeId, boolean isEnable, Integer userId, MultipartFile file, String updator) throws Exception;

    int updateByPrimaryKeySelective(Integer id, Integer printNameId, Integer printTypeId, boolean isEnable, Integer userId, MultipartFile file, String updator) throws Exception;

    /**
     * 根据多重条件进行查询
     *
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
            , Boolean isEnable
            , Integer userId
            , Integer pageNum, Integer PageSize);

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<JsonResult> getByPage(Integer pageNum, Integer pageSize);

    Map<String, JSONArray> dropdwon();

    /**
     * 根据条件查询用户所绑定的打印机
     */
    List<String> listByCondition(String userId, String printType, Boolean isEnable);
}
