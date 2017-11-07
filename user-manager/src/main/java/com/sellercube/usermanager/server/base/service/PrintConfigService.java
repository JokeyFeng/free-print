package com.sellercube.usermanager.server.base.service;


import com.github.pagehelper.PageInfo;
import com.sellercube.usermanager.common.BaseService;
import com.sellercube.usermanager.server.base.entity.PrintConfig;
import com.sellercube.usermanager.server.base.entity.vo.PrintConfigVO;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
public interface PrintConfigService extends BaseService<PrintConfig> {

    /**
     * 批量删除
     *
     * @param ids 以逗号分隔的字符串id
     * @return 1
     */
    int deleteByPrimaryKeyALL(String ids);

    /**
     * 分页获取手持打印配置
     *
     * @param pageNum page number
     * @param limit   limit size
     * @return {@link PageInfo<PrintConfigVO>}
     */
    PageInfo<PrintConfigVO> list(Integer pageNum, Integer limit);

    /**
     * 根据条件查询手持打印配置
     *
     * @param operateUserId 操作员id
     * @param ip            ip
     * @param warehouseId   仓库id
     * @param pageNum       page number
     * @param limit         limit size
     * @return {@link PageInfo<PrintConfigVO>}
     */
    PageInfo<PrintConfigVO> search(String operateUserId, String ip, Integer warehouseId, Integer pageNum, Integer limit);
}