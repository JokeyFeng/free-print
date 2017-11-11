package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.common.BaseMapper;
import com.sellercube.usermanager.server.base.entity.PrintType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
@Mapper
@Component
public interface PrintTypeMapper extends BaseMapper<PrintType> {
    /**
     * 根据打印类型名称搜索
     *
     * @param name 打印类型名称
     * @return {@link List<PrintType>}
     */
    List<PrintType> searchByName(String name);

    /**
     * 根据打印类型名称查询
     *
     * @param name 打印类型名称
     * @return {@link List<PrintType>}
     */
    PrintType selectByName(String name);

    /**
     * 分页获取打印类型
     *
     * @return {@link List<PrintType>}
     */
    List<PrintType> list();

    /**
     * 根据打印类型名称查询个数
     *
     * @param name 打印类型名称
     * @return {@link List<PrintType>}
     */
    int countByName(String name);
}