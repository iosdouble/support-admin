package com.zk.system.service.impl;

import com.zk.system.domain.WxkqLaunchCardRecord;
import com.zk.system.mapper.WxkqLaunchCardRecordMapper;
import com.zk.system.service.IWxkqLaunchCardRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname WxkqLaunchCardRecordServiceImpl
 * @Description TODO
 * @Date 2020/8/17 5:14 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WxkqLaunchCardRecordServiceImpl @see ruoyi
 */
@Service
public class WxkqLaunchCardRecordServiceImpl implements IWxkqLaunchCardRecordService {

    @Autowired
    private WxkqLaunchCardRecordMapper wxkqLaunchCardRecordMapper;


    public int insertLaunchCardRecord(WxkqLaunchCardRecord wxkqLaunchCardRecord){
        int insert = wxkqLaunchCardRecordMapper.insert(wxkqLaunchCardRecord);
        return insert;
    }
}
