package com.zk.system.service.impl;

import com.zk.system.domain.po.InsertCardBaseInfoPo;
import com.zk.system.mapper.WxkqCardBaseInfoMapper;
import com.zk.system.service.IWxkqCardBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int insertCardBaseInfo(InsertCardBaseInfoPo insertCardBaseInfoPo) {
        return 0;
    }
}
