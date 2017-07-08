package com.sellercube.usermanager.server.base.service;

import com.github.pagehelper.PageInfo;
import com.sellercube.usermanager.server.base.entity.User;

import java.util.List;

/**
 * Created by Chenjing on 2017/6/20.
 */
public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * user login handle
     *
     * @param account
     * @param password
     * @return
     */
    User login(String account, String password) throws Exception;

    List<User> list(String pageNum, String limit);

    PageInfo<User> search(String username, String account,String pageNum,String limit);
}
