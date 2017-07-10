package com.sellercube.usermanager.server.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.sellercube.common.utils.SplitUtil;
import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.mapper.ConfigMapper;
import com.sellercube.usermanager.server.base.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sellercube.usermanager.server.base.entity.Config;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Chenjing on 2017/7/8.
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public int deleteByPrimaryKeyALL(String ids) {
        SplitUtil.split(",", ids).forEach(x -> configMapper.deleteByPrimaryKey(Integer.valueOf(x)));
        return 1;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return configMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Config record) {
        record.setCretaeTime(new Date());
        return configMapper.insert(record);
    }

    @Override
    public int insertSelective(Config record) {
        record.setCretaeTime(new Date());
        return configMapper.insertSelective(record);
    }

    @Override
    public Config selectByPrimaryKey(Integer id) {
        return configMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Config record) {
        record.setUpdateTime(new Date());
        return configMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Config record) {
        record.setUpdateTime(new Date());
        return configMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Config> list(String pageNum, String limit) {
        Optional<String> pageNum1 = Optional.ofNullable(pageNum);
        Optional<String> limit1 = Optional.ofNullable(limit);
        PageHelper.startPage(Integer.valueOf(pageNum1.orElse("1")), Integer.valueOf(limit1.orElse("10")));
        return new PageInfo<>(configMapper.list());
    }

    @Override
    public PageInfo<Config> search(String printName, String ip, String mac, String pageNum, String limit) {
        Optional<String> pageNum1 = Optional.ofNullable(pageNum);
        Optional<String> limit1 = Optional.ofNullable(limit);
        PageHelper.startPage(Integer.valueOf(pageNum1.orElse("1")), Integer.valueOf(limit1.orElse("10")));
        return new PageInfo<>(configMapper.searchByCondition(printName, ip, mac));
    }

    @Override
    public boolean isConditionRepeat(String printName) throws Exception {
        Optional<String> name = Optional.ofNullable(printName);
        int result = name.map(x -> configMapper.countByPrintNameRepeat(x)).orElse(-1);
//        int result = nameResult == -1 ? account.map(x -> userMapper.countByAccountRepeat(x)).orElse(-1) : nameResult;
        if (result == -1) {
            throw new Exception("请传入参数");
        }
        return result > 0 ? true : false;
    }
}
