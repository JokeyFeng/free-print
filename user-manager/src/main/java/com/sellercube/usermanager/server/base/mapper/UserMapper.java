package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.server.base.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据账号和密码查找用户
     * @param account
     * @param password
     * @return
     */
    User findByAccountAndPwd(@Param("account") String account, @Param("password") String password);

    List<User> searchByCondition(@Param("username") String name);

    List<User> list();

    int countByNameRepeat(String name);

    int countByAccountRepeat(String account);
}