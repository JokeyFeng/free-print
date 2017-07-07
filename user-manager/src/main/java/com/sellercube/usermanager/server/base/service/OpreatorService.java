package com.sellercube.usermanager.server.base.service;

import com.sellercube.usermanager.server.base.entity.Opreator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Chenjing on 2017/6/22.
 */
public interface OpreatorService {
    int deleteByPrimaryKey(Integer id);

    int insert(Opreator record);

    int insertSelective(Opreator record);

    Opreator selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Opreator record);

    int updateByPrimaryKey(Opreator record);

    List<Opreator> list(HttpServletRequest request);
}
