package com.zk.system.mapper;

import com.zk.system.domain.GhNewsRes;
import com.zk.system.domain.GhNewsResExample;
import com.zk.system.domain.GhNewsResWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface GhNewsResMapper extends Serializable {
    long countByExample(GhNewsResExample example);

    int deleteByPrimaryKey(Long newId);

    int insert(GhNewsResWithBLOBs record);

    int insertSelective(GhNewsResWithBLOBs record);

    List<GhNewsResWithBLOBs> selectByExampleWithBLOBs(GhNewsResExample example);

    List<GhNewsRes> selectByExample(GhNewsResExample example);

    GhNewsResWithBLOBs selectByPrimaryKey(Long newId);

    int updateByExampleSelective(@Param("record") GhNewsResWithBLOBs record, @Param("example") GhNewsResExample example);

    int updateByExampleWithBLOBs(@Param("record") GhNewsResWithBLOBs record, @Param("example") GhNewsResExample example);

    int updateByExample(@Param("record") GhNewsRes record, @Param("example") GhNewsResExample example);

    int updateByPrimaryKeySelective(GhNewsResWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GhNewsResWithBLOBs record);

    int updateByPrimaryKey(GhNewsRes record);
}