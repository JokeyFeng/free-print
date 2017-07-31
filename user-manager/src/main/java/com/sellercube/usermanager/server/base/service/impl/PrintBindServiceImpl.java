package com.sellercube.usermanager.server.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import com.sellercube.common.function.Tuples;
import com.sellercube.common.utils.SplitUtil;
import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.PrintBind;
import com.sellercube.usermanager.server.base.mapper.ConfigMapper;
import com.sellercube.usermanager.server.base.mapper.PrintBindMapper;
import com.sellercube.usermanager.server.base.mapper.PrintTypeMapper;
import com.sellercube.usermanager.server.base.service.PrintBindService;
import com.sellercube.usermanager.server.base.service.UserService;
import com.sellercube.usermanager.util.RedisUtil;
import com.sellercube.usermanager.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Author:Administrator
 * Date: 2017/7/10
 * Email:JokeyFeng@foxmail.com
 * Version:1.0.0
 */
@Service
public class PrintBindServiceImpl implements PrintBindService {

    @Autowired
    private PrintBindMapper printBindMapper;

    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private PrintTypeMapper printTypeMapper;

    @Autowired
    private UserService userService;

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    public int insert(Integer printNameId, Integer printTypeId, boolean isEnable, Integer userId, MultipartFile file, String creator) throws Exception {
        List<JsonResult> list = printBindMapper.searchByCondition(printNameId, printTypeId, isEnable, userId);
        if (null != list && !list.isEmpty()) {
            throw new Exception("保存失败！打印机名称、打印类型、操作员、是否可用四项在打印绑定表中必须唯一!");
        }
        String uuid = UUID.randomUUID().toString();
        String suffix = SplitUtil.split(".", file.getOriginalFilename()).get(1);
        File dest = new File("/uploadFile/" + uuid + "." + suffix);
        file.transferTo(dest);
        PrintBind record = new PrintBind(printNameId, printTypeId, isEnable, userId, dest.getPath(), new Date(), creator, new Date(), null);
        record.setCreator(userService.selectByPrimaryKey(Integer.valueOf(record.getCreator())).getUsername());
        record.setUpdator(userService.selectByPrimaryKey(Integer.valueOf(record.getUpdator())).getUsername());
        return printBindMapper.insert(record);
    }

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    public int insertSelective(Integer printNameId, Integer printTypeId, boolean isEnable, Integer userId, MultipartFile file, String creator) throws Exception {
        List<JsonResult> list = printBindMapper.searchByCondition(printNameId, printTypeId, isEnable, userId);
        if (null != list && !list.isEmpty()) {
            throw new Exception("保存失败！打印机名称、打印类型、操作员、是否可用四项在打印绑定表中必须唯一!");
        }
        String uuid = UUID.randomUUID().toString();
        String suffix = SplitUtil.split(".", file.getOriginalFilename()).get(1);
        File dest = new File("/uploadFile/" + uuid + "." + suffix);
        file.transferTo(dest);
        PrintBind record = new PrintBind(printNameId, printTypeId, isEnable, userId, dest.getPath(), new Date(), creator, new Date(), null);
        record.setCreator(userService.selectByPrimaryKey(Integer.valueOf(record.getCreator())).getUsername());
        record.setUpdator(userService.selectByPrimaryKey(Integer.valueOf(record.getUpdator())).getUsername());
        return printBindMapper.insertSelective(record);
    }

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    public int deleteByPrimaryKey(Integer id) {
        return printBindMapper.deleteByPrimaryKey(id);
    }

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    public int deleteByKeys(String ids) {
        SplitUtil.split(",", ids).forEach(x -> printBindMapper.deleteByPrimaryKey(Integer.valueOf(x)));
        return 1;
    }

    @Override
    public PrintBind selectByPrimaryKey(Integer id) {
        return printBindMapper.selectByPrimaryKey(id);
    }

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    public int updateByPrimaryKey(Integer id, Integer printNameId, Integer printTypeId, boolean isEnable, Integer userId, MultipartFile file, String updator) throws Exception {
        List<JsonResult> list = printBindMapper.searchByCondition(printNameId, printTypeId, isEnable, userId);
        if (null != list && !list.isEmpty()) {
            throw new Exception("保存失败！打印机名称、打印类型、操作员、是否可用四项在打印绑定表中必须唯一!");
        }
        if (file == null || file.isEmpty()) {
            PrintBind record = new PrintBind(printNameId, printTypeId, isEnable, userId, null, null, null, new Date(), updator);
            record.setId(id);
            return printBindMapper.updateByPrimaryKey(record);
        } else {
            String uuid = UUID.randomUUID().toString();
            String suffix = SplitUtil.split(".", file.getOriginalFilename()).get(1);
            File dest = new File("/uploadFile/" + uuid + "." + suffix);
            file.transferTo(dest);
            PrintBind record = new PrintBind(printNameId, printTypeId, isEnable, userId, dest.getPath(), null, null, new Date(), updator);
            record.setId(id);
            record.setUpdator(userService.selectByPrimaryKey(Integer.valueOf(record.getUpdator())).getUsername());
            return printBindMapper.updateByPrimaryKey(record);
        }
    }

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    public int updateByPrimaryKeySelective(Integer id, Integer printNameId, Integer printTypeId, boolean isEnable, Integer userId, MultipartFile file, String updator) throws Exception {
        List<JsonResult> list = printBindMapper.searchByCondition(printNameId, printTypeId, isEnable, userId);
        if (null != list && !list.isEmpty()) {
            throw new Exception("保存失败！打印机名称、打印类型、操作员、是否可用四项在打印绑定表中必须唯一!");
        }
        if (file == null || file.isEmpty()) {
            PrintBind record = new PrintBind(printNameId, printTypeId, isEnable, userId, null, null, null, new Date(), updator);
            record.setId(id);
            return printBindMapper.updateByPrimaryKeySelective(record);
        } else {
            String uuid = UUID.randomUUID().toString();
            String suffix = SplitUtil.split(".", file.getOriginalFilename()).get(1);
            File dest = new File("/uploadFile/" + uuid + "." + suffix);
            file.transferTo(dest);
            PrintBind record = new PrintBind(printNameId, printTypeId, isEnable, userId, dest.getPath(), null, null, new Date(), updator);
            record.setId(id);
            record.setUpdator(userService.selectByPrimaryKey(Integer.valueOf(record.getUpdator())).getUsername());
            return printBindMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    @Cacheable(value = "redisCache", keyGenerator = "keyGenerator", cacheManager = "cacheManager")
    public PageInfo<JsonResult> searchByCondition(Integer configId
            , Integer typeId
            , Boolean isEnable
            , Integer userId
            , Integer pageNum, Integer PageSize) {
        PageHelper.startPage(pageNum, PageSize);
        return new PageInfo<>(printBindMapper.searchByCondition(configId, typeId, isEnable, userId));
    }


    @Override
    @Cacheable(value = "redisCache", keyGenerator = "keyGenerator", cacheManager = "cacheManager")
    public PageInfo<JsonResult> getByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(printBindMapper.list());
    }

    @Override
    @Cacheable(value = "redisCache", keyGenerator = "keyGenerator", cacheManager = "cacheManager")
    public Map<String, JSONArray> dropdwon() {
        JSONArray var1 = new JSONArray();
        JSONArray var2 = new JSONArray();
        JSONArray var3 = new JSONArray();
        Map<String, JSONArray> map = Maps.newHashMap();
        configMapper.list().forEach(x -> var1.add(Tuples.of(x.getId(), x.getPrintName())));
        map.put("printName", var1);
        printTypeMapper.list().forEach(x -> var2.add(Tuples.of(x.getId().toString(), x.getTypeName())));
        map.put("printType", var2);
        userService.list().forEach(x -> var3.add(Tuples.of(x.getUserid().toString(), x.getUsername())));
        map.put("userName", var3);
        return map;
    }
}
