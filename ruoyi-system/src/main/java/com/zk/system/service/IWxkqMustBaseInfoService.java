package com.zk.system.service;

import java.util.List;
import com.zk.system.domain.WxkqMustBaseInfo;

/**
 * 微信卡券基础信息必填信息 Service接口
 * 
 * @author ruoyi
 * @date 2020-08-14
 */
public interface IWxkqMustBaseInfoService 
{
    /**
     * 查询微信卡券基础信息必填信息 
     * 
     * @param id 微信卡券基础信息必填信息 ID
     * @return 微信卡券基础信息必填信息 
     */
    public WxkqMustBaseInfo selectWxkqMustBaseInfoById(Long id);

    /**
     * 查询微信卡券基础信息必填信息 列表
     * 
     * @param wxkqMustBaseInfo 微信卡券基础信息必填信息 
     * @return 微信卡券基础信息必填信息 集合
     */
    public List<WxkqMustBaseInfo> selectWxkqMustBaseInfoList(WxkqMustBaseInfo wxkqMustBaseInfo);

    /**
     * 新增微信卡券基础信息必填信息 
     * 
     * @param wxkqMustBaseInfo 微信卡券基础信息必填信息 
     * @return 结果
     */
    public int insertWxkqMustBaseInfo(WxkqMustBaseInfo wxkqMustBaseInfo);

    /**
     * 修改微信卡券基础信息必填信息 
     * 
     * @param wxkqMustBaseInfo 微信卡券基础信息必填信息 
     * @return 结果
     */
    public int updateWxkqMustBaseInfo(WxkqMustBaseInfo wxkqMustBaseInfo);

    /**
     * 批量删除微信卡券基础信息必填信息 
     * 
     * @param ids 需要删除的微信卡券基础信息必填信息 ID
     * @return 结果
     */
    public int deleteWxkqMustBaseInfoByIds(Long[] ids);

    /**
     * 删除微信卡券基础信息必填信息 信息
     * 
     * @param id 微信卡券基础信息必填信息 ID
     * @return 结果
     */
    public int deleteWxkqMustBaseInfoById(Long id);
}
