package com.sellercube.usermanager.server.base.mapper;


import com.sellercube.usermanager.common.BaseMapper;
import com.sellercube.usermanager.server.base.entity.User;
import com.sellercube.usermanager.server.base.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Chenjing on 2017/11/7
 *
 * @author Chenjing
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {
    /**
     * 分页查询用户
     *
     * @return {@link List<UserVO>}
     */
    List<UserVO> list();

    /**
     * 根据用户名搜索用户
     *
     * @param userName 用户名
     * @return {@link List<UserVO>}
     */
    List<UserVO> search(String userName);
}