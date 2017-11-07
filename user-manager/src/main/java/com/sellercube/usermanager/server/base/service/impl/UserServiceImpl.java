package com.sellercube.usermanager.server.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sellercube.usermanager.common.BaseServiceImpl;
import com.sellercube.usermanager.server.base.entity.User;
import com.sellercube.usermanager.server.base.entity.vo.UserVO;
import com.sellercube.usermanager.server.base.mapper.UserMapper;
import com.sellercube.usermanager.server.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chenjing on 2017/6/20.
 *
 * @author Chenjing
 */

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserMapper var1) {
        super.baseMapper = var1;
        this.userMapper = var1;
    }

    @Override
    public PageInfo<UserVO> list(Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        return new PageInfo<>(userMapper.list());
    }

    @Override
    public PageInfo<UserVO> search(String userName, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        return new PageInfo<>(userMapper.search(userName));
    }

}
