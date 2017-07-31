package com.sellercube.usermanager.server.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.sellercube.common.utils.SplitUtil;
import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.PrintType;
import com.sellercube.usermanager.server.base.mapper.PrintTypeMapper;
import com.sellercube.usermanager.server.base.service.PrintService;
import com.sellercube.usermanager.server.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * Created by Chenjing on 2017/7/8.
 */
@Service
public class PrintServiceImpl implements PrintService {

    @Autowired
    private PrintTypeMapper printTypeMapper;

    @Autowired
    private UserService userService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return printTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(String ids) {
        SplitUtil.split(",", ids).forEach(x -> printTypeMapper.deleteByPrimaryKey(Integer.valueOf(x)));
        return 1;
    }

    @Override
    public int insert(PrintType record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreator(userService.selectByPrimaryKey(Integer.valueOf(record.getCreator())).getUsername());
        record.setUpdator(userService.selectByPrimaryKey(Integer.valueOf(record.getUpdator())).getUsername());
        return printTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(PrintType record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreator(userService.selectByPrimaryKey(Integer.valueOf(record.getCreator())).getUsername());
        record.setUpdator(userService.selectByPrimaryKey(Integer.valueOf(record.getUpdator())).getUsername());
        return printTypeMapper.insertSelective(record);
    }

    @Override
    public PrintType selectByPrimaryKey(Integer id) {
        return printTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PrintType record) {
        record.setUpdateTime(new Date());
        record.setUpdator(userService.selectByPrimaryKey(Integer.valueOf(record.getUpdator())).getUsername());
        return printTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PrintType record) {
        record.setUpdateTime(new Date());
        record.setUpdator(userService.selectByPrimaryKey(Integer.valueOf(record.getUpdator())).getUsername());
        return printTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<PrintType> searchByName(String var1, String var2, String var3) {
        Optional<String> pageNum = Optional.ofNullable(var2);
        Optional<String> limit = Optional.ofNullable(var3);
        PageHelper.startPage(Integer.valueOf(pageNum.orElse("1")), Integer.valueOf(limit.orElse("10")));
        return new PageInfo<>(printTypeMapper.searchByName(var1));
    }

    @Override
    public PageInfo<PrintType> list(String var1, String var2) {
        Optional<String> pageNum = Optional.ofNullable(var1);
        Optional<String> limit = Optional.ofNullable(var2);
        PageHelper.startPage(Integer.valueOf(pageNum.orElse("1")), Integer.valueOf(limit.orElse("10")));
        return new PageInfo<>(printTypeMapper.list());
    }

    @Override
    public boolean countByName(String name) {
        return printTypeMapper.countByName(name) > 0 ? true : false;
    }
}
