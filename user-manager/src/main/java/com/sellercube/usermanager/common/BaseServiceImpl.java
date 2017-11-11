package com.sellercube.usermanager.common;

import org.springframework.util.Assert;

/**
 * Created by Chenjing on 2017/11/1.
 *
 * @author Chenjing
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    protected BaseMapper<T> baseMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        Assert.notNull(id, "参数为空");
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        Assert.notNull(record, "参数为空");
        return baseMapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        Assert.notNull(record, "参数为空");
        return baseMapper.insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(String id) {
        Assert.notNull(id, "参数为空");
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        Assert.notNull(record, "参数为空");
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        Assert.notNull(record, "参数为空");
        return baseMapper.updateByPrimaryKey(record);
    }
}
