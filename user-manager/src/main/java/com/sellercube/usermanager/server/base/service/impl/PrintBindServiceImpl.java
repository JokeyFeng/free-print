package com.sellercube.usermanager.server.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.sellercube.common.utils.SplitUtil;
import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.PrintBind;
import com.sellercube.usermanager.server.base.mapper.PrintBindMapper;
import com.sellercube.usermanager.server.base.service.PrintBindService;
import com.sellercube.usermanager.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Author:Administrator
 * Date: 2017/7/10
 * Email:JokeyFeng@foxmail.com
 * Version:1.0.0
 */
@Service
public class PrintBindServiceImpl implements PrintBindService {

    @Autowired
    private PrintBindMapper printBindMapper;

    @Override
    public int insert(PrintBind record) throws Exception {
        List<JsonResult> list = printBindMapper.searchByCondition(record.getConfigId(), record.getPrintTypeId(), record.getIsEnable(), record.getUserId());
        if (list.size() != 0) {
            throw new Exception("保存失败！打印机名称、打印类型、操作员、是否可用四项在打印绑定表中必须唯一!");
        }
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        return printBindMapper.insert(record);
    }

    @Override
    public int insertSelective(PrintBind record) throws Exception{
        List<JsonResult> list = printBindMapper.searchByCondition(record.getConfigId(), record.getPrintTypeId(), record.getIsEnable(), record.getUserId());
        if (list.size() != 0) {
            throw new Exception("保存失败！打印机名称、打印类型、操作员、是否可用四项在打印绑定表中必须唯一!");
        }
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        return printBindMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return printBindMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByKeys(String ids) {
        List<String> keys = SplitUtil.split(",", ids);
        for (String key : keys) {
            printBindMapper.deleteByPrimaryKey(Integer.valueOf(key));
        }
        return 1;
    }

    @Override
    public PrintBind selectByPrimaryKey(Integer id) {
        return printBindMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(PrintBind record) throws Exception {
        List<JsonResult> list = printBindMapper.searchByCondition(record.getConfigId(), record.getPrintTypeId(), record.getIsEnable(), record.getUserId());
        if (list.size() == 0) {
            throw new Exception("修改失败！打印机名称、打印类型、操作员、是否可用四项在打印绑定表中必须唯一!");
        }
        record.setUpdateTime(new Date());
        return printBindMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(PrintBind record) throws Exception {
        List<JsonResult> list = printBindMapper.searchByCondition(record.getConfigId(), record.getPrintTypeId(), record.getIsEnable(), record.getUserId());
        if (list.size() == 0) {
            throw new Exception("修改失败！打印机名称、打印类型、操作员、是否可用四项在打印绑定表中必须唯一!");
        }
        record.setUpdateTime(new Date());
        return printBindMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<JsonResult> searchByCondition(Integer configId
                                                , Integer typeId
                                                , boolean isEnable
                                                , Integer userId
                                                , Integer pageNum, Integer PageSize) {
        PageHelper.startPage(pageNum,PageSize);
        return new PageInfo<>(printBindMapper.searchByCondition(configId,typeId,isEnable,userId));
    }


    @Override
    public PageInfo<JsonResult> getByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(printBindMapper.list());
    }
}
