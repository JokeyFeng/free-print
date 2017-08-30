package com.sellercube.usermanager.server.base.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import com.sellercube.common.function.Tuples;
import com.sellercube.common.utils.SplitUtil;
import com.sellercube.usermanager.common.PageInfo;
import com.sellercube.usermanager.server.base.entity.PrintConfig;
import com.sellercube.usermanager.server.base.mapper.PrintConfigMapper;
import com.sellercube.usermanager.server.base.service.PrintConfigService;
import com.sellercube.usermanager.server.base.service.StorageService;
import com.sellercube.usermanager.server.base.service.UserService;
import com.sellercube.usermanager.vo.PrintConfigVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Chenjing on 2017/8/24.
 */
@Service
public class PrintConfigServiceImpl implements PrintConfigService {

    @Autowired
    private PrintConfigMapper printConfigMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private StorageService storageService;

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    public int deleteByPrimaryKey(Integer printConfigId) {
        return printConfigMapper.deleteByPrimaryKey(printConfigId);
    }

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    public int insert(PrintConfig record) {
        record.setCreateDate(new Date());
        record.setModifyDate(new Date());
        return printConfigMapper.insert(record);
    }

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    public int insertSelective(PrintConfig record) {
        record.setCreateDate(new Date());
        record.setModifyDate(new Date());
        return printConfigMapper.insertSelective(record);
    }

    @Override
    public PrintConfig selectByPrimaryKey(Integer printConfigId) {
        return printConfigMapper.selectByPrimaryKey(printConfigId);
    }

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    public int updateByPrimaryKeySelective(PrintConfig record) {
        record.setModifyDate(new Date());
        return printConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    public int updateByPrimaryKey(PrintConfig record) {
        record.setModifyDate(new Date());
        return printConfigMapper.updateByPrimaryKey(record);
    }

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    public int deleteByPrimaryKeyALL(String ids) {
        SplitUtil.split(",", ids).forEach(x -> printConfigMapper.deleteByPrimaryKey(Integer.valueOf(x)));
        return 1;
    }

    @Override
    @Cacheable(value = "redisCache", keyGenerator = "keyGenerator", cacheManager = "cacheManager")
    public PageInfo<PrintConfigVO> list(String pageNum, String limit) {
        Optional<String> pageNum1 = Optional.ofNullable(pageNum);
        Optional<String> limit1 = Optional.ofNullable(limit);
        PageHelper.startPage(Integer.valueOf(pageNum1.orElse("1")), Integer.valueOf(limit1.orElse("10")));
        List<PrintConfig> printConfigList = printConfigMapper.list();
        PageInfo<PrintConfig> pageInfo = new PageInfo<>(printConfigList);
        PageInfo<PrintConfigVO> pageInfoVO = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setList(resultTrans(printConfigList));
        return pageInfoVO;
    }

    @Override
    public PageInfo<PrintConfigVO> search(String operateName, String ip, Integer warehouseId, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<PrintConfig> printConfigList = printConfigMapper.searchByCondition(operateName, ip, warehouseId);
        PageInfo<PrintConfig> pageInfo = new PageInfo<>(printConfigList);
        PageInfo<PrintConfigVO> pageInfoVO = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setList(resultTrans(printConfigList));
        return pageInfoVO;
    }

    @Override
    @Cacheable(value = "redisCache", keyGenerator = "keyGenerator", cacheManager = "cacheManager")
    public Map<String, JSONArray> dropdown() {
        JSONArray var1 = new JSONArray();
        JSONArray var3 = new JSONArray();
        Map<String, JSONArray> map = Maps.newHashMap();
        userService.list().forEach(x -> var3.add(Tuples.of(x.getUserid().toString(), x.getUsername())));
        storageService.list().forEach(x -> var1.add(Tuples.of(x.getStorageid().toString(), x.getStoragename())));
        map.put("userName", var3);
        List<String> ips = printConfigMapper.distinctByIP();
        ips.remove(null);
        ips.remove("");
        map.put("ip", JSON.parseArray(ips.toString()));
        map.put("warehouse", var1);
        return map;
    }

    /**
     * 对返回结果进行封装
     */
    private List<PrintConfigVO> resultTrans(List<PrintConfig> printConfigs) {
        Map<Integer, String> userMap = Maps.newHashMap();
        Map<Integer, String> storageMap = Maps.newHashMap();
        userService.list().forEach(x -> userMap.put(x.getUserid(), x.getUsername()));
        storageService.list().forEach(x -> storageMap.put(x.getStorageid(), x.getStoragename()));
        return printConfigs.stream().map(x -> {
            PrintConfigVO printConfigVO = new PrintConfigVO();
            BeanUtils.copyProperties(x, printConfigVO);
            printConfigVO.setCreateUserName(userMap.get(x.getCreateUserId()));
            printConfigVO.setModifyUserName(userMap.get(x.getModifyUserId()));
            printConfigVO.setOperateUserName(userMap.get(x.getOperateUserId()));
            printConfigVO.setStorageId(storageMap.get(x.getStorageId()));
            return printConfigVO;
        }).collect(Collectors.toList());
    }
}
