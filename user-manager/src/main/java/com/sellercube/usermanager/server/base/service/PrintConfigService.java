package com.sellercube.usermanager.server.base.service;


import com.github.pagehelper.PageInfo;
import com.sellercube.usermanager.common.BaseService;
import com.sellercube.usermanager.server.base.entity.PrintConfig;
import com.sellercube.usermanager.server.base.entity.vo.PrintConfigVO;

public interface PrintConfigService extends BaseService<PrintConfig> {

    int deleteByPrimaryKeyALL(String ids);

    PageInfo<PrintConfigVO> list(Integer pageNum, Integer limit);

    PageInfo<PrintConfigVO> search(String operateUserId, String ip, Integer warehouseId, Integer pageNum, Integer limit);
}