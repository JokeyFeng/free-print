package com.sellercube.usermanager.server.base.mapper;

import com.sellercube.usermanager.common.BaseMapper;
import com.sellercube.usermanager.server.base.entity.PrintType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Chenjing on 2017/11/1.
 *
 * @author Chenjing
 */
@Component
@Mapper
public interface TestMapper extends BaseMapper<PrintType> {
}
