package com.zk.system.service.impl;

import com.zk.common.utils.idgenerator.SnowflakeIdUtils;
import com.zk.system.domain.WxkqCreateCardDetailsInfo;
import com.zk.system.domain.po.InsertCreateCardDetailsPo;
import com.zk.system.mapper.WxkqCreateCardDetailsInfoMapper;
import com.zk.system.service.IWxkqCreateCardDetailsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Classname WxkqCreateCardDetailsInfoServiceImpl
 * @Description TODO
 * @Date 2020/8/18 9:34 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WxkqCreateCardDetailsInfoServiceImpl @see ruoyi
 */
@Service
public class WxkqCreateCardDetailsInfoServiceImpl implements IWxkqCreateCardDetailsInfoService {

    @Autowired
    private WxkqCreateCardDetailsInfoMapper wxkqCreateCardDetailsInfoMapper;

    @Override
    public int insertCreateCardDetails(InsertCreateCardDetailsPo insertCreateCardDetailsPo) {

        SnowflakeIdUtils snowflakeIdUtils = new SnowflakeIdUtils(1,1);


        WxkqCreateCardDetailsInfo wxkqCreateCardDetailsInfo = new WxkqCreateCardDetailsInfo();
        wxkqCreateCardDetailsInfo.setId(snowflakeIdUtils.nextId());
        wxkqCreateCardDetailsInfo.setOptionId(insertCreateCardDetailsPo.getOptionId());
        wxkqCreateCardDetailsInfo.setCardType(insertCreateCardDetailsPo.getCardType());
        wxkqCreateCardDetailsInfo.setCreateBy(insertCreateCardDetailsPo.getCreateBy());
        wxkqCreateCardDetailsInfo.setCreateParameterDetail(insertCreateCardDetailsPo.getDetail());

        wxkqCreateCardDetailsInfo.setCreateTime(new Date());
        wxkqCreateCardDetailsInfo.setDelFlag(1);
        wxkqCreateCardDetailsInfo.setStatus(1);
        wxkqCreateCardDetailsInfo.setLastUpdateBy(insertCreateCardDetailsPo.getCreateBy());
        wxkqCreateCardDetailsInfo.setLastUpdateTime(new Date());
        int insert = wxkqCreateCardDetailsInfoMapper.insert(wxkqCreateCardDetailsInfo);
        return insert;
    }
}
