package com.zk.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zk.system.mapper.WxkqMustBaseInfoMapper;
import com.zk.system.domain.WxkqMustBaseInfo;
import com.zk.system.service.IWxkqMustBaseInfoService;

/**
 * 微信卡券基础信息必填信息 Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-14
 */
@Service
public class WxkqMustBaseInfoServiceImpl implements IWxkqMustBaseInfoService 
{
    @Autowired
    private WxkqMustBaseInfoMapper wxkqMustBaseInfoMapper;

    /**
     * 查询微信卡券基础信息必填信息 
     * 
     * @param id 微信卡券基础信息必填信息 ID
     * @return 微信卡券基础信息必填信息 
     */
    @Override
    public WxkqMustBaseInfo selectWxkqMustBaseInfoById(Long id)
    {
        return wxkqMustBaseInfoMapper.selectWxkqMustBaseInfoById(id);
    }

    /**
     * 查询微信卡券基础信息必填信息 列表
     * 
     * @param wxkqMustBaseInfo 微信卡券基础信息必填信息 
     * @return 微信卡券基础信息必填信息 
     */
    @Override
    public List<WxkqMustBaseInfo> selectWxkqMustBaseInfoList(WxkqMustBaseInfo wxkqMustBaseInfo)
    {
        return wxkqMustBaseInfoMapper.selectWxkqMustBaseInfoList(wxkqMustBaseInfo);
    }

    /**
     * 新增微信卡券基础信息必填信息 
     * 
     * @param wxkqMustBaseInfo 微信卡券基础信息必填信息 
     * @return 结果
     */
    @Override
    public int insertWxkqMustBaseInfo(WxkqMustBaseInfo wxkqMustBaseInfo)
    {
        return wxkqMustBaseInfoMapper.insertWxkqMustBaseInfo(wxkqMustBaseInfo);
    }

    /**
     * 修改微信卡券基础信息必填信息 
     * 
     * @param wxkqMustBaseInfo 微信卡券基础信息必填信息 
     * @return 结果
     */
    @Override
    public int updateWxkqMustBaseInfo(WxkqMustBaseInfo wxkqMustBaseInfo)
    {
        return wxkqMustBaseInfoMapper.updateWxkqMustBaseInfo(wxkqMustBaseInfo);
    }

    /**
     * 批量删除微信卡券基础信息必填信息 
     * 
     * @param ids 需要删除的微信卡券基础信息必填信息 ID
     * @return 结果
     */
    @Override
    public int deleteWxkqMustBaseInfoByIds(Long[] ids)
    {
        return wxkqMustBaseInfoMapper.deleteWxkqMustBaseInfoByIds(ids);
    }

    /**
     * 删除微信卡券基础信息必填信息 信息
     * 
     * @param id 微信卡券基础信息必填信息 ID
     * @return 结果
     */
    @Override
    public int deleteWxkqMustBaseInfoById(Long id)
    {
        return wxkqMustBaseInfoMapper.deleteWxkqMustBaseInfoById(id);
    }
}
