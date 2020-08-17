package com.zk.system.mapper;

import com.zk.system.domain.WxkqCreateCardRecord;
import com.zk.system.domain.WxkqCreateCardRecordExample;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface WxkqCreateCardRecordMapper extends Serializable {
    long countByExample(WxkqCreateCardRecordExample example);

    int insert(WxkqCreateCardRecord record);

    int insertSelective(WxkqCreateCardRecord record);

    List<WxkqCreateCardRecord> selectByExample(WxkqCreateCardRecordExample example);

    int updateByExampleSelective(@Param("record") WxkqCreateCardRecord record, @Param("example") WxkqCreateCardRecordExample example);

    int updateByExample(@Param("record") WxkqCreateCardRecord record, @Param("example") WxkqCreateCardRecordExample example);
}