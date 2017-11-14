package com.sellercube.usermanager.server.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.sellercube.common.utils.SplitUtil;
import com.sellercube.usermanager.common.BaseServiceImpl;
import com.sellercube.usermanager.server.base.entity.PrintConfig;
import com.sellercube.usermanager.server.base.entity.PrintType;
import com.sellercube.usermanager.server.base.entity.vo.PrintConfigVO;
import com.sellercube.usermanager.server.base.mapper.PrintConfigMapper;
import com.sellercube.usermanager.server.base.mapper.PrintTypeMapper;
import com.sellercube.usermanager.server.base.mapper.StorageMapper;
import com.sellercube.usermanager.server.base.mapper.UserMapper;
import com.sellercube.usermanager.server.base.service.PrintConfigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by Chenjing on 2017/8/24.
 *
 * @author Chenjing
 */
@Service
public class PrintConfigServiceImpl extends BaseServiceImpl<PrintConfig> implements PrintConfigService {

    private PrintConfigMapper printConfigMapper;

    private UserMapper userMapper;

    private StorageMapper storageMapper;

    private PrintTypeMapper printTypeMapper;

    public PrintConfigServiceImpl() {
    }

    @Autowired
    public PrintConfigServiceImpl(PrintConfigMapper var1, UserMapper var2,
                                  StorageMapper var3, PrintTypeMapper var4) {
        super.baseMapper = var1;
        this.printConfigMapper = var1;
        this.userMapper = var2;
        this.storageMapper = var3;
        this.printTypeMapper = var4;
    }

    /**
     * 用户缓存
     */
    private static Cache<Integer, String> userCache = CacheBuilder.newBuilder()
            .maximumSize(20000)
            .expireAfterAccess(12, TimeUnit.HOURS)
            .build();
    /**
     * 仓库缓存
     */
    private static Cache<Integer, String> storageCache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(12, TimeUnit.HOURS)
            .build();
    /**
     * 打印类型缓存
     */
    private static Cache<Integer, String> printTypeCache = CacheBuilder.newBuilder()
            .maximumSize(50)
            .expireAfterAccess(12, TimeUnit.HOURS)
            .build();

    @Override
    public int deleteByPrimaryKeyALL(String ids) {
        return SplitUtil.split(",", ids).stream().mapToInt(x -> printConfigMapper.deleteByPrimaryKey(x)).sum();
    }

    @Override
    public PageInfo<PrintConfigVO> list(Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<PrintConfig> printConfigList = printConfigMapper.list();
        PageInfo<PrintConfig> pageInfo = new PageInfo<>(printConfigList);
        PageInfo<PrintConfigVO> pageInfoVO = new PageInfo<>();
        //设置返回的pageInfo的属性
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setList(this.resultConvert(printConfigList));
        return pageInfoVO;
    }

    @Override
    public PageInfo<PrintConfigVO> search(String operateUserId, Integer warehouseId, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<PrintConfig> printConfigList = printConfigMapper.searchByCondition(operateUserId, warehouseId);
        PageInfo<PrintConfig> pageInfo = new PageInfo<>(printConfigList);
        PageInfo<PrintConfigVO> pageInfoVO = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setList(this.resultConvert(printConfigList));
        return pageInfoVO;
    }

    @Override
    public String findIpByCondition(String userId, String printType) throws Exception {
        PrintType printTypeResult = printTypeMapper.selectByName(printType);

        if (null == printTypeResult) {
            throw new Exception("获取打印类型id失败，请确保打印类型名称唯一和存在");
        }
        String printTypeId = printTypeResult.getId().toString();
        String ip;
        List<String> ipList = printConfigMapper.findIpByCondition(userId, printTypeId);
        if (null != ipList && !ipList.isEmpty() && ipList.size() == 1) {
            ip = ipList.get(0);
        } else {
            throw new Exception("获取IP失败，请确保IP不会被重复或存在");
        }
        return ip;
    }


    /**
     * 对返回结果PrintConfig转换成PrintConfigVO
     *
     * @param printConfigs {@link List<PrintConfig>}
     * @return {@link List<PrintConfigVO>}
     */
    private List<PrintConfigVO> resultConvert(List<PrintConfig> printConfigs) {
        return printConfigs.stream().map((PrintConfig x) -> {
            PrintConfigVO printConfigVO = new PrintConfigVO();
            BeanUtils.copyProperties(x, printConfigVO);
            try {
                printConfigVO.setCreateUserName(userCache.get(x.getCreateUserId(),
                        () -> userMapper.selectByPrimaryKey(x.getCreateUserId().toString()).getUsername()));

                printConfigVO.setModifyUserName(userCache.get(x.getModifyUserId(),
                        () -> userMapper.selectByPrimaryKey(x.getModifyUserId().toString()).getUsername()));

                printConfigVO.setOperateUserName(userCache.get(x.getOperateUserId(),
                        () -> userMapper.selectByPrimaryKey(x.getOperateUserId().toString()).getUsername()));

                printConfigVO.setStorageName(storageCache.get(x.getStorageId(),
                        () -> storageMapper.selectByPrimaryKey(x.getStorageId().toString()).getStoragename()));

                printConfigVO.setPrintTypeName(printTypeCache.get(x.getPrintTypeId(),
                        () -> printTypeMapper.selectByPrimaryKey(x.getPrintTypeId().toString()).getTypeName()));
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return printConfigVO;
        }).collect(Collectors.toList());
    }
}
