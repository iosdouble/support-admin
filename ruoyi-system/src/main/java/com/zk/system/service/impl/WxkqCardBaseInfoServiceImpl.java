package com.zk.system.service.impl;

import com.zk.common.utils.idgenerator.SnowflakeIdUtils;
import com.zk.system.domain.WxkqCardBaseInfo;
import com.zk.system.domain.WxkqCardBaseInfoExample;
import com.zk.system.domain.po.InsertCardBaseInfoPo;
import com.zk.system.mapper.WxkqCardBaseInfoMapper;
import com.zk.system.service.IWxkqCardBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Classname WxkqCardBaseInfoServiceImpl
 * @Description TODO
 * @Date 2020/8/19 6:00 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WxkqCardBaseInfoServiceImpl @see ruoyi
 */
@Service
public class WxkqCardBaseInfoServiceImpl implements IWxkqCardBaseInfoService {

    @Autowired
    private WxkqCardBaseInfoMapper wxkqCardBaseInfoMapper;

    @Override
    public Long insertCardBaseInfo(InsertCardBaseInfoPo insertCardBaseInfoPo) {
        WxkqCardBaseInfo wxkqCardBaseInfo = new WxkqCardBaseInfo();
        SnowflakeIdUtils snowflakeIdUtils = new SnowflakeIdUtils(1,1);

        wxkqCardBaseInfo.setId(snowflakeIdUtils.nextId());
        wxkqCardBaseInfo.setCardId(insertCardBaseInfoPo.getCard_id());
        wxkqCardBaseInfo.setCodeType(insertCardBaseInfoPo.getCode_type());
        wxkqCardBaseInfo.setBrandName(insertCardBaseInfoPo.getBrand_name());
        wxkqCardBaseInfo.setTitle(insertCardBaseInfoPo.getTitle());
        wxkqCardBaseInfo.setQuantity(insertCardBaseInfoPo.getQuantity());
        if (insertCardBaseInfoPo.getUse_custom_code()){
            wxkqCardBaseInfo.setUseCustomCode(1);
        }else {
            wxkqCardBaseInfo.setUseCustomCode(0);
        }
        wxkqCardBaseInfo.setGetCustomCodeMode(insertCardBaseInfoPo.getGet_custom_code_mode());
        wxkqCardBaseInfo.setBeginTimeStamp(insertCardBaseInfoPo.getBegin_time_stamp());
        wxkqCardBaseInfo.setEndTimeStamp(insertCardBaseInfoPo.getEnd_time_stamp());
        wxkqCardBaseInfo.setCreateBy(insertCardBaseInfoPo.getUrser_name());

        wxkqCardBaseInfo.setCreateTime(new Date());
        wxkqCardBaseInfo.setLastUpdateBy("system");
        wxkqCardBaseInfo.setLastUpdateTime(new Date());
        wxkqCardBaseInfo.setDelFlag(0);
        wxkqCardBaseInfo.setStatus(0);

        int insert = wxkqCardBaseInfoMapper.insert(wxkqCardBaseInfo);

        return wxkqCardBaseInfo.getId();
    }

    @Override
    public List<WxkqCardBaseInfo> getAllInfo() {
        WxkqCardBaseInfoExample wxkqCardBaseInfoExample = new WxkqCardBaseInfoExample();
        wxkqCardBaseInfoExample.setOrderByClause("create_time DESC");
        List<WxkqCardBaseInfo> wxkqCardBaseInfos = wxkqCardBaseInfoMapper.selectByExample(wxkqCardBaseInfoExample);
        return wxkqCardBaseInfos;
    }
}
