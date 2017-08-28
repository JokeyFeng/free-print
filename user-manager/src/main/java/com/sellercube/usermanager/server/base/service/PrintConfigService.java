package com.sellercube.usermanager.server.base.service;


import com.alibaba.fastjson.JSONArray;
import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.PrintConfig;
import com.sellercube.usermanager.vo.PrintConfigVO;

import java.util.Map;

public interface PrintConfigService {
    int deleteByPrimaryKey(Integer printConfigId);

    int insert(PrintConfig record);

    int insertSelective(PrintConfig record);

    PrintConfig selectByPrimaryKey(Integer printConfigId);

    int updateByPrimaryKeySelective(PrintConfig record);

    int updateByPrimaryKey(PrintConfig record);

    int deleteByPrimaryKeyALL(String ids);

    PageInfo<PrintConfigVO> list(String pageNum, String limit);

    PageInfo<PrintConfigVO> search(String operateName, String ip, Integer warehouseId, Integer pageNum, Integer limit);

    Map<String,JSONArray> dropdown();
}