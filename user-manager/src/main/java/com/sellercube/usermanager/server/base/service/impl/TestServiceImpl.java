package com.sellercube.usermanager.server.base.service.impl;

import com.sellercube.usermanager.common.BaseServiceImpl;
import com.sellercube.usermanager.server.base.entity.PrintType;
import com.sellercube.usermanager.server.base.mapper.TestMapper;
import com.sellercube.usermanager.server.base.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chenjing on 2017/11/1.
 *
 * @author Chenjing
 */
@Service
public class TestServiceImpl extends BaseServiceImpl<PrintType> implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    public void init(TestMapper var) {
        super.baseMapper = var;
    }
}
