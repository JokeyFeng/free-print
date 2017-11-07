package com.sellercube.usermanager.server.base.service;

import com.github.pagehelper.PageInfo;
import com.sellercube.usermanager.common.BaseService;
import com.sellercube.usermanager.server.base.entity.User;
import com.sellercube.usermanager.server.base.entity.vo.UserVO;

/**
 * Created by Chenjing on 2017/6/20.
 */
public interface UserService extends BaseService<User> {

    PageInfo<UserVO> list(Integer var1, Integer var2);

    PageInfo<UserVO> search(String var1, Integer var2, Integer var3);
}
