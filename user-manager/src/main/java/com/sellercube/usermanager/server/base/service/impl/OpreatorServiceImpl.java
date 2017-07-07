package com.sellercube.usermanager.server.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sellercube.usermanager.server.base.entity.Opreator;
import com.sellercube.usermanager.server.base.mapper.OpreatorMapper;
import com.sellercube.usermanager.server.base.service.OpreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Chenjing on 2017/6/22.
 */
@Service
public class OpreatorServiceImpl implements OpreatorService {

    @Autowired
    private OpreatorMapper opreatorMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return opreatorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Opreator record) {
        return opreatorMapper.insert(record);
    }

    @Override
    public int insertSelective(Opreator record) {
        return opreatorMapper.insertSelective(record);
    }

    @Override
    public Opreator selectByPrimaryKey(Integer id) {
        return opreatorMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Opreator record) {
        return opreatorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Opreator record) {
        return opreatorMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Opreator> list(HttpServletRequest request) {
        PageHelper.startPage(Integer.valueOf(request.getParameter("offset")),
                Integer.valueOf(request.getParameter("limit")));
        return opreatorMapper.list();
    }
}
