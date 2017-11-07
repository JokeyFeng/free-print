package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.common.BaseMapper;
import com.sellercube.usermanager.server.base.entity.PrintType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PrintTypeMapper extends BaseMapper<PrintType> {
    List<PrintType> searchByName(String name);

    List<PrintType> list();

    int countByName(String name);
}