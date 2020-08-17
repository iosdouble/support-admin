package com.zk.system.mapper;

import com.zk.system.domain.WxkqLaunchCardRecord;
import com.zk.system.domain.WxkqLaunchCardRecordExample;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface WxkqLaunchCardRecordMapper extends Serializable {
    long countByExample(WxkqLaunchCardRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WxkqLaunchCardRecord record);

    int insertSelective(WxkqLaunchCardRecord record);

    List<WxkqLaunchCardRecord> selectByExample(WxkqLaunchCardRecordExample example);

    WxkqLaunchCardRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WxkqLaunchCardRecord record, @Param("example") WxkqLaunchCardRecordExample example);

    int updateByExample(@Param("record") WxkqLaunchCardRecord record, @Param("example") WxkqLaunchCardRecordExample example);

    int updateByPrimaryKeySelective(WxkqLaunchCardRecord record);

    int updateByPrimaryKey(WxkqLaunchCardRecord record);
}