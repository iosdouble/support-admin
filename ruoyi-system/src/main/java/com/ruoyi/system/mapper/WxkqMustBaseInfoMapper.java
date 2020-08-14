package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.WxkqMustBaseInfo;

/**
 * 微信卡券基础信息必填信息 Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-14
 */
public interface WxkqMustBaseInfoMapper 
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
     * 删除微信卡券基础信息必填信息 
     * 
     * @param id 微信卡券基础信息必填信息 ID
     * @return 结果
     */
    public int deleteWxkqMustBaseInfoById(Long id);

    /**
     * 批量删除微信卡券基础信息必填信息 
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxkqMustBaseInfoByIds(Long[] ids);
}
