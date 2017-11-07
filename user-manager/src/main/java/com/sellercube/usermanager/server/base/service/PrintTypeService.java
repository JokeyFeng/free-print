package com.sellercube.usermanager.server.base.service;

import com.github.pagehelper.PageInfo;
import com.sellercube.usermanager.common.BaseService;
import com.sellercube.usermanager.server.base.entity.PrintType;

/**
 * Created by Chenjing on 2017/7/8.
 */
public interface PrintTypeService extends BaseService<PrintType> {

    PageInfo<PrintType> searchByName(String name, String pageNum, String limit);

    PageInfo<PrintType> list(String pageNum, String limit);

    boolean countByName(String name);

    int deleteByPrimaryKeyALL(String ids);
}
