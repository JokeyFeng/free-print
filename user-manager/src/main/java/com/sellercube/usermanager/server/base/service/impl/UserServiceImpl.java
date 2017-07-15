package com.sellercube.usermanager.server.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.sellercube.common.utils.MD5Util;
import com.sellercube.common.utils.SplitUtil;
import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.User;
import com.sellercube.usermanager.server.base.entity.UserDTO;
import com.sellercube.usermanager.server.base.mapper.UserMapper;
import com.sellercube.usermanager.server.base.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Chenjing on 2017/6/20.
 */

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Value("${access.token}")
    private String token;

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(String ids) {
        SplitUtil.split(",", ids).forEach(x -> userMapper.deleteByPrimaryKey(Integer.valueOf(x)));
        return 1;
    }

    @Override
    public int insert(User record) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        String password = record.getPassword();
        record.setPassword(MD5Util.encryption(password));
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setPassword(MD5Util.encryption(record.getPassword()));
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserDTO record) throws Exception {
        Optional<User> user = Optional.ofNullable(userMapper.findByAccountAndPwd(record.getAccount(), MD5Util.encryption(record.getPassword())));
        user.orElseThrow(Exception::new);
        record.setUpdateTime(new Date());
        record.setPassword(MD5Util.encryption(record.getNewPassword()));
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        record.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User login(String account, String password) throws Exception {
        User user = userMapper.findByAccountAndPwd(account, MD5Util.encryption(password));
        if (Objects.equals(null, user)) {
            throw new Exception("账号或者密码错误！");
        }
        user.setAccessToken(token);
        return user;
    }

    @Override
    public PageInfo<User> list(String pageNum, String limit) {
        Optional<String> pageNum1 = Optional.ofNullable(pageNum);
        Optional<String> limit1 = Optional.ofNullable(limit);
        PageHelper.startPage(Integer.valueOf(pageNum1.orElse("1")), Integer.valueOf(limit1.orElse("10")));
        return new PageInfo<>(userMapper.list());
    }

    @Override
    public PageInfo<User> search(String username, String account, String pageNum, String limit) {
        Optional<String> pageNum1 = Optional.ofNullable(pageNum);
        Optional<String> limit1 = Optional.ofNullable(limit);
        PageHelper.startPage(Integer.valueOf(pageNum1.orElse("1")), Integer.valueOf(limit1.orElse("10")));
        return new PageInfo<>(userMapper.searchByCondition(account, username));
    }

    @Override
    public boolean isConditionRepeat(String var1, String var2) throws Exception {
        Optional<String> name = Optional.ofNullable(var1);
        Optional<String> account = Optional.ofNullable(var2);
        int nameResult = name.map(x -> userMapper.countByNameRepeat(x)).orElse(-1);
        int result = nameResult == -1 ? account.map(x -> userMapper.countByAccountRepeat(x)).orElse(-1) : nameResult;
        if (result == -1) {
            throw new Exception("请传入参数");
        }
        return result > 0 ? true : false;
    }
}
