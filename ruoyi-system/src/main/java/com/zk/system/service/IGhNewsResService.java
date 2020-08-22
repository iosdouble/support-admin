package com.zk.system.service;

import com.zk.system.domain.GhNewsRes;
import com.zk.system.domain.GhNewsResWithBLOBs;
import com.zk.system.domain.vo.CreateNewsVo;

import java.util.List;

/**
 * @Classname IGhNewsResService
 * @Description TODO
 * @Date 2020/8/22 10:20 AM
 * @Created by nihui
 * @Version 1.0
 * @Description IGhNewsResService @see ruoyi
 */
public interface IGhNewsResService {
    public int insertNewsInfo(CreateNewsVo createNewsVo);

    public List<GhNewsResWithBLOBs> findAllNewS();
}
