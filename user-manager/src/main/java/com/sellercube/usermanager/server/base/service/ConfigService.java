package com.sellercube.usermanager.server.base.service;

import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.Config;

/**
 * Created by Chenjing on 2017/7/8.
 */
public interface ConfigService {

    int deleteByPrimaryKeyALL(String ids);

    int deleteByPrimaryKey(Integer id);

    int insert(Config record);

    int insertSelective(Config record);

    Config selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);

    PageInfo<Config> list(String pageNum, String limit);

    PageInfo<Config> search(String printName,String ip,String mac, String pageNum, String limit);

    boolean isConditionRepeat(String printName) throws Exception;
}
