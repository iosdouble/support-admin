package com.zk.system.service.impl;

import com.zk.common.utils.idgenerator.SnowflakeIdUtils;
import com.zk.system.domain.WxkqCreateCardRecord;
import com.zk.system.domain.WxkqCreateCardRecordExample;
import com.zk.system.domain.weixin.domain.resp.CreateCardSuccessResp;
import com.zk.system.mapper.WxkqCreateCardRecordMapper;
import com.zk.system.service.IWxkqCreateCardRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
    public String insertRecord(CreateCardSuccessResp createCardSuccessResp) {
        WxkqCreateCardRecord wxkqCreateCardRecord = new WxkqCreateCardRecord();
        SnowflakeIdUtils snowflakeIdUtils = new SnowflakeIdUtils(1, 1);
        wxkqCreateCardRecord.setId(snowflakeIdUtils.nextId());
        wxkqCreateCardRecord.setCardId(createCardSuccessResp.getCard_id());
        wxkqCreateCardRecord.setCardType("GROUPON");
        wxkqCreateCardRecord.setCreateBy("system");
        wxkqCreateCardRecord.setUseCustomCode(0);
        wxkqCreateCardRecord.setCreateTime(new Date());
        wxkqCreateCardRecord.setErrcode(createCardSuccessResp.getErrcode());
        wxkqCreateCardRecord.setErrmsg(createCardSuccessResp.getErrmsg());
        wxkqCreateCardRecord.setCardId(createCardSuccessResp.getCard_id());
        wxkqCreateCardRecord.setStatus(0);
        wxkqCreateCardRecord.setDelFlag(0);
        int insert = wxkqCreateCardRecordMapper.insert(wxkqCreateCardRecord);
        return wxkqCreateCardRecord.getCardId();
    }

    @Override
    public List<WxkqCreateCardRecord> queueAll() {

        WxkqCreateCardRecordExample wxkqCreateCardRecordExample = new WxkqCreateCardRecordExample();
        wxkqCreateCardRecordExample.setOrderByClause("create_time DESC");
        return wxkqCreateCardRecordMapper.selectByExample(wxkqCreateCardRecordExample);
    }
}
