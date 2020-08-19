package com.zk.system.mapper;

import com.zk.system.domain.WxkqCreateCardDetailsInfo;
import com.zk.system.domain.WxkqCreateCardDetailsInfoExample;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface WxkqCreateCardDetailsInfoMapper extends Serializable {
    long countByExample(WxkqCreateCardDetailsInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WxkqCreateCardDetailsInfo record);

    int insertSelective(WxkqCreateCardDetailsInfo record);

    List<WxkqCreateCardDetailsInfo> selectByExampleWithBLOBs(WxkqCreateCardDetailsInfoExample example);

    List<WxkqCreateCardDetailsInfo> selectByExample(WxkqCreateCardDetailsInfoExample example);

    WxkqCreateCardDetailsInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WxkqCreateCardDetailsInfo record, @Param("example") WxkqCreateCardDetailsInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") WxkqCreateCardDetailsInfo record, @Param("example") WxkqCreateCardDetailsInfoExample example);

    int updateByExample(@Param("record") WxkqCreateCardDetailsInfo record, @Param("example") WxkqCreateCardDetailsInfoExample example);

    int updateByPrimaryKeySelective(WxkqCreateCardDetailsInfo record);

    int updateByPrimaryKeyWithBLOBs(WxkqCreateCardDetailsInfo record);

    int updateByPrimaryKey(WxkqCreateCardDetailsInfo record);
}