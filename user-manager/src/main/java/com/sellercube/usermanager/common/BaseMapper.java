package com.sellercube.usermanager.common;

/**
 * Created by Chenjing on 2017/11/1.
 *
 * @author Chenjing
 */
public interface BaseMapper<T> {

    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}

