package com.sellercube.usermanager.server.base.service;

import com.sellercube.usermanager.server.base.entity.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Chenjing on 2017/6/20.
 */
public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKey(String ids);

    int insert(User record) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    int insertSelective(User record) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record) throws Exception;

    int updateByPrimaryKey(User record);

    List<User> list();


}
