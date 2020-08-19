package com.zk.system.mapper;

import com.zk.system.domain.WxkqGetCardStatusRecord;
import com.zk.system.domain.WxkqGetCardStatusRecordExample;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface WxkqGetCardStatusRecordMapper extends Serializable {
    long countByExample(WxkqGetCardStatusRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WxkqGetCardStatusRecord record);

    int insertSelective(WxkqGetCardStatusRecord record);

    List<WxkqGetCardStatusRecord> selectByExample(WxkqGetCardStatusRecordExample example);

    WxkqGetCardStatusRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WxkqGetCardStatusRecord record, @Param("example") WxkqGetCardStatusRecordExample example);

    int updateByExample(@Param("record") WxkqGetCardStatusRecord record, @Param("example") WxkqGetCardStatusRecordExample example);

    int updateByPrimaryKeySelective(WxkqGetCardStatusRecord record);

    int updateByPrimaryKey(WxkqGetCardStatusRecord record);
}