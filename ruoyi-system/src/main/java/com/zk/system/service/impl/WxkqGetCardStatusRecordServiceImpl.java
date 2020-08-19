package com.zk.system.service.impl;

import com.zk.system.domain.WxkqGetCardStatusRecord;
import com.zk.system.mapper.WxkqGetCardStatusRecordMapper;
import com.zk.system.service.IWxkqGetCardStatusRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname WxkqGetCardStatusRecordServiceImpl
 * @Description TODO
 * @Date 2020/8/18 9:10 AM
 * @Created by nihui
 * @Version 1.0
 * @Description WxkqGetCardStatusRecordServiceImpl @see ruoyi
 */
@Service
public class WxkqGetCardStatusRecordServiceImpl implements IWxkqGetCardStatusRecordService {


    @Autowired
    private WxkqGetCardStatusRecordMapper wxkqGetCardStatusRecordMapper;


    @Override
    public int insertCardStatusRecord(WxkqGetCardStatusRecord wxkqGetCardStatusRecord) {
        wxkqGetCardStatusRecordMapper.insert(wxkqGetCardStatusRecord);
        return 0;
    }
}
