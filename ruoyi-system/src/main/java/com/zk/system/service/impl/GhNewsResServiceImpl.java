package com.zk.system.service.impl;

import com.zk.common.core.domain.model.LoginUser;
import com.zk.common.utils.DateUtils;
import com.zk.common.utils.idgenerator.SnowflakeIdUtils;
import com.zk.system.domain.GhNewsRes;
import com.zk.system.domain.GhNewsResExample;
import com.zk.system.domain.GhNewsResWithBLOBs;
import com.zk.system.domain.vo.CreateNewsVo;
import com.zk.system.mapper.GhNewsResMapper;
import com.zk.system.service.IGhNewsResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Classname GhNewsResServiceImpl
 * @Description TODO
 * @Date 2020/8/22 10:21 AM
 * @Created by nihui
 * @Version 1.0
 * @Description GhNewsResServiceImpl @see ruoyi
 */
@Service
public class GhNewsResServiceImpl implements IGhNewsResService {

    @Autowired
    private GhNewsResMapper ghNewsResMapper;

    @Override
    public int insertNewsInfo(CreateNewsVo createNewsVo) {
        LoginUser principal = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        GhNewsResWithBLOBs ghNewsRes = new GhNewsResWithBLOBs();
        SnowflakeIdUtils snowflakeIdUtils = new SnowflakeIdUtils(1,1);
        ghNewsRes.setNewId(snowflakeIdUtils.nextId());
        ghNewsRes.setApplyUserCode(principal.getUser().getUserId());
        ghNewsRes.setDeptCode(principal.getUser().getDeptId());
        ghNewsRes.setDeptName(principal.getUser().getDept().getDeptName());
        ghNewsRes.setNewTitle(createNewsVo.getTitle());
        ghNewsRes.setNewContext(createNewsVo.getValue());
        ghNewsRes.setApplyDateTime(DateUtils.getTime());
        ghNewsRes.setCreateTime(new Date());
        ghNewsRes.setUpdateTime(new Date());
        ghNewsRes.setStatus(0);
        ghNewsRes.setDelFlag(1);
        ghNewsResMapper.insert(ghNewsRes);
        return 0;
    }

    @Override
    public List<GhNewsResWithBLOBs> findAllNewS() {
        GhNewsResExample ghNewsResExample = new GhNewsResExample();
        List<GhNewsResWithBLOBs> ghNewsRes = ghNewsResMapper.selectByExampleWithBLOBs(ghNewsResExample);
        return ghNewsRes;
    }
}
