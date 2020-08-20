package com.zk.system.mapper;

import com.zk.system.domain.WxkqCardBaseInfo;
import com.zk.system.domain.WxkqCardBaseInfoExample;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface WxkqCardBaseInfoMapper extends Serializable {
    long countByExample(WxkqCardBaseInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WxkqCardBaseInfo record);

    int insertSelective(WxkqCardBaseInfo record);

    List<WxkqCardBaseInfo> selectByExample(WxkqCardBaseInfoExample example);

    WxkqCardBaseInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WxkqCardBaseInfo record, @Param("example") WxkqCardBaseInfoExample example);

    int updateByExample(@Param("record") WxkqCardBaseInfo record, @Param("example") WxkqCardBaseInfoExample example);

    int updateByPrimaryKeySelective(WxkqCardBaseInfo record);

    int updateByPrimaryKey(WxkqCardBaseInfo record);
}