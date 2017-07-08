package com.sellercube.usermanager.server.base.service;

import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.PrintType;

/**
 * Created by Chenjing on 2017/7/8.
 */
public interface PrintService {
    int deleteByPrimaryKey(Integer id);

    int insert(PrintType record);

    int insertSelective(PrintType record);

    PrintType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrintType record);

    int updateByPrimaryKey(PrintType record);

    PageInfo<PrintType> searchByName(String name, String pageNum, String limit);

    PageInfo<PrintType> list(String pageNum, String limit);
}
