package com.sellercube.usermanager.server.base.service;

import com.github.pagehelper.PageInfo;
import com.sellercube.usermanager.common.BaseService;
import com.sellercube.usermanager.server.base.entity.User;
import com.sellercube.usermanager.server.base.entity.vo.UserVO;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
public interface UserService extends BaseService<User> {
    /**
     * 分页获取用户
     *
     * @param var1 页码
     * @param var2 大小
     * @return {@link PageInfo<UserVO>}
     */
    PageInfo<UserVO> list(Integer var1, Integer var2);

    /**
     * 根据条件分页搜索用户
     *
     * @param var1 username
     * @param var2 page number
     * @param var3 limit size
     * @return {@link PageInfo<UserVO>}
     */
    PageInfo<UserVO> search(String var1, Integer var2, Integer var3);
}
