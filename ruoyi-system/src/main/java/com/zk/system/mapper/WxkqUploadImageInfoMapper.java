package com.zk.system.mapper;

import com.zk.system.domain.WxkqUploadImageInfo;
import com.zk.system.domain.WxkqUploadImageInfoExample;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface WxkqUploadImageInfoMapper extends Serializable {
    long countByExample(WxkqUploadImageInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxkqUploadImageInfo record);

    int insertSelective(WxkqUploadImageInfo record);

    List<WxkqUploadImageInfo> selectByExampleWithBLOBs(WxkqUploadImageInfoExample example);

    List<WxkqUploadImageInfo> selectByExample(WxkqUploadImageInfoExample example);

    WxkqUploadImageInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxkqUploadImageInfo record, @Param("example") WxkqUploadImageInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") WxkqUploadImageInfo record, @Param("example") WxkqUploadImageInfoExample example);

    int updateByExample(@Param("record") WxkqUploadImageInfo record, @Param("example") WxkqUploadImageInfoExample example);

    int updateByPrimaryKeySelective(WxkqUploadImageInfo record);

    int updateByPrimaryKeyWithBLOBs(WxkqUploadImageInfo record);

    int updateByPrimaryKey(WxkqUploadImageInfo record);
}