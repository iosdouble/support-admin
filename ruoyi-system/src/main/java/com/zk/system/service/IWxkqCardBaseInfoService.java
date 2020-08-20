package com.zk.system.service;

import com.zk.system.domain.WxkqCardBaseInfo;
import com.zk.system.domain.WxkqCreateCardRecord;
import com.zk.system.domain.po.InsertCardBaseInfoPo;

import java.util.List;

/**
 * @Classname IWxkqCardBaseInfoService
 * @Description TODO
 * @Date 2020/8/19 5:59 PM
 * @Created by nihui
 * @Version 1.0
 * @Description IWxkqCardBaseInfoService @see ruoyi
 */
public interface IWxkqCardBaseInfoService {

    // 插入记录
    public Long insertCardBaseInfo(InsertCardBaseInfoPo insertCardBaseInfoPo);

    public List<WxkqCardBaseInfo> getAllInfo();


}
