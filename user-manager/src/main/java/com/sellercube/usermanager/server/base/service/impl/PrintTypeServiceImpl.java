package com.sellercube.usermanager.server.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sellercube.common.utils.SplitUtil;
import com.sellercube.usermanager.common.BaseServiceImpl;
import com.sellercube.usermanager.server.base.entity.PrintType;
import com.sellercube.usermanager.server.base.mapper.PrintTypeMapper;
import com.sellercube.usermanager.server.base.service.PrintTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Chenjing on 2017/7/8.
 *
 * @author Chenjing
 */
@Service
public class PrintTypeServiceImpl extends BaseServiceImpl<PrintType> implements PrintTypeService {

    private PrintTypeMapper printTypeMapper;

    public PrintTypeServiceImpl() {
    }

    @Autowired
    public PrintTypeServiceImpl(PrintTypeMapper var1) {
        super.baseMapper = var1;
        this.printTypeMapper = var1;
    }


    @Override
    public int deleteByPrimaryKeyALL(String ids) {
        SplitUtil.split(",", ids).forEach(x -> printTypeMapper.deleteByPrimaryKey(x));
        return 1;
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
        return printTypeMapper.countByName(name) > 0;
    }
}
