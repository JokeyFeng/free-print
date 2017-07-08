package com.sellercube.usermanager.server.base.service;

import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.User;

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

    PageInfo<User> list(String pageNum, String limit);

    PageInfo<User> search(String username, String account, String pageNum, String limit);

    /**
     * 判断是否重复
     * @param name
     * @return
     */
    boolean isConditionRepeat(String name,String account) throws Exception;

}
