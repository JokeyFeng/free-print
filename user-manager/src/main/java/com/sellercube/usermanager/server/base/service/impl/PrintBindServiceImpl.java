package com.sellercube.usermanager.server.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.PrintBind;
import com.sellercube.usermanager.server.base.mapper.PrintBindMapper;
import com.sellercube.usermanager.server.base.service.PrintBindService;
import com.sellercube.usermanager.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public int insert(PrintBind record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        return printBindMapper.insert(record);
    }

    @Override
    public int insertSelective(PrintBind record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        return printBindMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return printBindMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PrintBind selectByPrimaryKey(Integer id) {
        return printBindMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(PrintBind record) {
        record.setUpdateTime(new Date());
        return printBindMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(PrintBind record) {
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
