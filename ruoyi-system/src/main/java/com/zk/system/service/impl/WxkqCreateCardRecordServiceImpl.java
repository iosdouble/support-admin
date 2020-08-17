package com.zk.system.service.impl;

import com.zk.system.domain.WxkqCreateCardRecord;
import com.zk.system.mapper.WxkqCreateCardRecordMapper;
import com.zk.system.service.IWxkqCreateCardRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Classname WxkqCreateCardRecordServiceImpl
 * @Description TODO
 * @Date 2020/8/15 3:55 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WxkqCreateCardRecordServiceImpl @see ruoyi
 */
@Service
public class WxkqCreateCardRecordServiceImpl implements IWxkqCreateCardRecordService {

    @Autowired
    private WxkqCreateCardRecordMapper wxkqCreateCardRecordMapper;


    @Transactional
    @Override
    public int insertRecord(WxkqCreateCardRecord wxkqCreateCardRecord) {
        int insert = wxkqCreateCardRecordMapper.insert(wxkqCreateCardRecord);
        return insert;
    }
}
