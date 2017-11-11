package com.sellercube.usermanager.server.base.service;

import com.github.pagehelper.PageInfo;
import com.sellercube.usermanager.common.BaseService;
import com.sellercube.usermanager.server.base.entity.PrintType;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
public interface PrintTypeService extends BaseService<PrintType> {
    /**
     * 根据名称分页查询打印类型
     *
     * @param name    打印类型名称
     * @param pageNum page number
     * @param limit   limit size
     * @return {@link PageInfo<PrintType>}
     */
    PageInfo<PrintType> searchByName(String name, String pageNum, String limit);

    /**
     * 分页获取打印类型
     *
     * @param pageNum page number
     * @param limit   limit size
     * @return {@link PageInfo<PrintType>}
     */
    PageInfo<PrintType> list(String pageNum, String limit);

    /**
     * 根据打印名称判断是否重复
     *
     * @param name 打印类型名称
     * @return true or false
     */
    boolean countByName(String name);

    /**
     * 批量删除
     *
     * @param ids 以逗号分隔的字符串id
     * @return 1
     */
    int deleteByPrimaryKeyALL(String ids);

    /**
     * 根据名称查找
     *
     * @param name 打印类型名称
     * @return {@link PrintType}
     */
    PrintType selectByName(String name);
}
