package com.zk.system.service;

import com.zk.system.domain.WxkqCreateCardRecord;
import com.zk.system.domain.weixin.domain.resp.CreateCardSuccessResp;

import java.util.List;

/**
 * @Classname IWxkqCreateCardRecordService
 * @Description TODO
 * @Date 2020/8/15 3:54 PM
 * @Created by nihui
 * @Version 1.0
 * @Description IWxkqCreateCardRecordService @see ruoyi
 */
public interface IWxkqCreateCardRecordService {

    /**
     * 新增一条提交记录
     * @return
     */
    public int insertRecord(CreateCardSuccessResp createCardSuccessResp);

    public List<WxkqCreateCardRecord> queueAll();
}
